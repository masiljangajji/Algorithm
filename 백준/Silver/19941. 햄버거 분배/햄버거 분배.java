import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) throws IOException {


        // 자신의 위치에서 거리가 K 이하인 햄버거를 먹을 수 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()); // 식탁 길이
        int k = Integer.parseInt(stk.nextToken()); // 햄버거 선택 거리

        // 사람 P, 햄버거 H

        String str = br.readLine();

        int cnt = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') { // 이 앞에 먹을 수 있는 햄버거 있는지 확인  -> 없으면 이 뒤에 먹을 수 있는 햄버거 있는지 확인

                int start = Math.max(i - k, 0);
                int end = Math.min(i + k, str.length() - 1);

                for (; start <= end; start++) {

                    if (str.charAt(start) == 'H' && !visited[start]) { // 방문안했고, 햄버거면 체크
                        visited[start] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);

    }


}