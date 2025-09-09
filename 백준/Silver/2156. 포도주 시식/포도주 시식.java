import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        /**
         * 연속으로 놓여 있는 3잔을 마실 수 없다
         */

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }


        // 0 이면 다음번에가 3번째가 아니다

        if (n <= 3) {

            if (n == 1) {
                System.out.println(arr[1]);
                return;
            } else if (n == 2) {
                System.out.println(arr[1] + arr[2]);
                return;
            }
            System.out.println(Math.max(Math.max(arr[1] + arr[3], arr[2] + arr[3]), arr[1] + arr[2]));
            return;
        }

        int max = 0;

        dp[1][1] = arr[1];
        dp[2][0] = arr[1];
        dp[2][1] = arr[2];
        dp[2][2] = arr[2] + arr[1];
        dp[3][0] = arr[1] + arr[2];
        dp[3][1] = arr[1] + arr[3];
        dp[3][2] = arr[2] + arr[3];

        max = get(dp[3][0], dp[3][1], dp[3][2]);

        for (int i = 4; i <= n; i++) {
            dp[i][0] = get(dp[i - 1][2], dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = get(dp[i - 2][2] + arr[i], dp[i - 2][1] + arr[i], dp[i - 2][0] + arr[i]);
            dp[i][2] = dp[i - 1][1] + arr[i];
            max = Math.max(max, get(dp[i][1], dp[i][2], dp[i][0]));
        }

        System.out.println(max);
    }

    public static int get(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}