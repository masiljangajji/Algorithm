import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    public static Map<Integer, Rank> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        // k 개의 문제 0 ~ 100점 사이의 점수
        // ID, 문제 번호, 점수가 로그에 저장

        // 한 문제에 대한 풀이는 여러번 가능, 최고 점수가 최종 점수가 됨

        // 예외 조건

        /**
         *
         * 최종 점수 같으면 제출 횟수가 적은 팀이 이김
         * 최종 점수 같고, 횟수도 같으면, 마지막 제출 시간이 빠른 팀이 이김
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            StringTokenizer stk = new StringTokenizer(br.readLine());


            map.clear();
            int n = Integer.parseInt(stk.nextToken()); // 팀의 개수
            int k = Integer.parseInt(stk.nextToken()); // 문제 개수
            int id = Integer.parseInt(stk.nextToken()); // 우리팀의 id
            int m = Integer.parseInt(stk.nextToken()); // 로그 엔트리 수


            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());


                Rank rank = map.get(teamId);

                if (Objects.isNull(rank)) {

                    Rank initRank = new Rank(teamId);
                    initRank.add(problemId, score, j);
                    map.put(teamId, initRank);
                } else {
                    rank.add(problemId, score, j);
                }
            }


            List<Rank> ranks = map.values().stream()
                    .sorted((r1, r2) -> {
                        if (r1.totalScore() == r2.totalScore()) {
                            if (r1.totalSubmit == r2.totalSubmit) {
                                return r1.lastSubmitIdx - r2.lastSubmitIdx;
                            }
                            return r1.totalSubmit - r2.totalSubmit;
                        }
                        return r2.totalScore() - r1.totalScore();
                    })
                    .collect(Collectors.toList());

            for (int p = 0; p < ranks.size(); p++) {
                if (ranks.get(p).teamId == id) {
                    System.out.println(p + 1);
                    break;
                }
            }


        }
    }

}

class Rank {

    Map<Integer, Integer> map = new HashMap<>();

    int teamId;

    int lastSubmitIdx = 0;

    int totalSubmit = 0;

    // 문제 - 문제에 대한 점수
    // 이런식으로 엮여야 할 듯

    public Rank(int teamId) {
        this.teamId = teamId;
    }

    public void add(int problemId, int score, int lastSubmitIdx) {

        totalSubmit++;
        this.lastSubmitIdx = lastSubmitIdx;

        if (map.containsKey(problemId)) {
            map.replace(problemId, Math.max(map.get(problemId), score));
            return;
        }

        map.put(problemId, score);
    }

    public int totalScore() {
        return map.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }


}


