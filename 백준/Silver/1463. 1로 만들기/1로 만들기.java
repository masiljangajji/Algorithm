import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X가 3으로 나누어 떨어지면, 3으로 나눈다.

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        // 3가지 선택지로 1로 만드는걸 하고있다
        // 그래서 선택지에 따른 분기가 많아짐
        // 역으로 가면 최적의 경로만 남음 , 1을 더하거나, 2를 곱하거나, 3을 곱해서 숫자 n을 만들겠다

        int[] dp = new int[1000001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }


        System.out.println(dp[n]);


    }

}