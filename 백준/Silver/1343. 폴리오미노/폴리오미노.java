import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // 폴리오미노 2종류 AAAA, BB

        // . X 로 이루어진 보드판이 주어졌을 때, 겹침없이 X 를 모두 폴리오미노로 덮으려고 한다.
        // . 는 폴리오미노로 덮으면 안 된다.

        // 사전순으로 앞서야 하기 때문에 AAAA가 먼저 나와줘야 함

        String str = sc.nextLine();

        int start = 0;

        int cnt = 0;

        StringBuilder stb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        while (start < str.length()) {
            if (str.charAt(start) == 'X') { // 덮어도 됨
                cnt++;
            } else if (str.charAt(start) == '.') { // 덮으면 안됨

                if (cnt != 0)
                    q.offer(cnt);
                q.offer(-1);
                cnt = 0;
            }
            start++;
        }

        if (cnt != 0) {
            q.offer(cnt);
        }


        while (!q.isEmpty()) {

            int n = q.poll();

            if (n == -1) {
                stb.append(".");
                continue;
            }

            if (n % 2 != 0) { // 홀수
                System.out.println(-1);
                return;
            }

            int division = n / 4;

            if (division == 0) {
                stb.append("BB");
            } else if (division > 0) {

                for (int i = 0; i < division; i++) {
                    stb.append("AAAA");
                }

                for (int i = 0; i < n % 4; i += 2) {
                    stb.append("BB");
                }

            }

        }

        System.out.println(stb);

    }

}


