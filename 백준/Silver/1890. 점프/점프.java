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

        int n = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (dp[i][j] == 0 || (i == n && j == n))
                    continue;

                if (j + arr[i][j] <= n) {
                    dp[i][j + arr[i][j]] += dp[i][j];
                }

                if (i + arr[i][j] <= n) {
                    dp[i + arr[i][j]][j] += dp[i][j];
                }

            }
        }

        System.out.println(dp[n][n]);

    }
}

class Pair {

    int y;
    int x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}