import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int[] arr = new int[5001];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         *
         *
         * 첫 번째 돌에서 출발, 마지막까지 간다.
         *
         * i번째 돌에서 j번째로 이동할때 (j-i) x )1 + Math.abs(arr[i]-arr[j])) 힘을 쓴다.
         *
         * 쓸 수 있는 힘은 최대 k이다.
         *
         */

        // k 를 못넘기면 못 넘어가겠네

        int n, k;

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // k 가 허락하는 선에서 , +1 , +2 , +3, +4 ,+5 를 전부 체크하면 되는 문제

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        for (int i = 1; i < n; i++) {

            if (!visited[i]) {
                continue;
            }

            for (int j = i + 1; j <= n; j++) {
                if (go(i, j) <= k) {
                    visited[j] = true;
                }
            }
        }

        if (visited[n]) {
            System.out.println("YES");
        } else
            System.out.println("NO");


    }

    public static int go(int i, int j) {
        return (j - i) * (1 + Math.abs(arr[i] - arr[j]));
    }


}