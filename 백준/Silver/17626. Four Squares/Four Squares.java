import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static int SIZE;
    public static int MAX = 12345;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 모든 자연수는 넷 , 그 이하의 제곱수의 합으로 표현 가능

        int n = sc.nextInt();

        int[] dp = new int[50001];

        Arrays.fill(dp, 1234567890);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 2;
        dp[9] = 1;

        for (int i = 10; i <= 50000; i++) {
            int j = 1;
            while (j * j <= i) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }

        System.out.println(dp[n]);

    }


}