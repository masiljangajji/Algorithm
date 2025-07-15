import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 4 ~ 12 키로미터
        // 한 팀은 여섯 명의 선수로 구성
        // 팀 점수는 상위 네 명의 주자의 점수를 합하여 ㅖ산
        // 결승점을 통과한 순서대로 점수를 받음
        // 점수를 더하여 가장 낮은 점수를 얻는 팀이 우승
        // 여섯 명의 주자가 참가하지 못한 팀은 점수 계산에서 제외  ( 예외 )
        // 동점의 경우 다섯 번째 주자가 가장 빨리 들어온 팀이 우승

        // 여섯명 보다 많이 참가하는 경우는 없음

        int t = sc.nextInt();

        while (t > 0) {

            t--;

            int n = sc.nextInt();

            int[] cnt = new int[201];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                cnt[num]++;
                list.add(num);
            }

            int rank = 1;
            Map<Integer, Rank> m = new HashMap<>();

            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);

                if (cnt[num] == 6) {
                    m.computeIfAbsent(num, integer -> new Rank(num)).add(rank);
                    rank++;
                }

            }

            System.out.println(
                    m.values().stream().filter(Rank::isValidate)
                            .sorted((o1, o2) -> {
                                if (o1.getTotal() == o2.getTotal()) {
                                    return o1.getFive() - o2.getFive();
                                }
                                return o1.getTotal() - o2.getTotal();
                            })
                            .findFirst()
                            .get()
                            .team
            );

        }

    }

}

class Rank {

    int team;
    List<Integer> scores = new ArrayList<>();

    public Rank(int team) {
        this.team = team;
    }

    public void add(int score) {
        this.scores.add(score);
    }

    public int getTotal() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += scores.get(i);
        }
        return sum;
    }

    public int getFive() {
        return this.scores.get(4);
    }

    public boolean isValidate() {
        return this.scores.size() == 6;
    }

    @Override
    public String toString() {
        return team + " " + getTotal() + " " + getFive();
    }


}

