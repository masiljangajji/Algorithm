import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int SIZE;
    public static int MAX = 12345;

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 모든 자연수는 넷 , 그 이하의 제곱수의 합으로 표현 가능


        // 원하는 위치에 수를 골라 K번 삭제 가능
        // 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이
        // k번 삭제 가능 = 홀수가 k개까지 있어도 괜찮음

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        int idx = 0;
        while (stk.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(stk.nextToken());
            idx++;
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                if (arr[i - 1] % 2 == 0) { // 짝수
                    dp[i][j] = dp[i - 1][j] + 1;
                    continue;
                }

                // 홀수
                if (j > 0) { // 허용한 홀수 갯수 
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);

    }


}