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

        // 마지막 돌 틈 사이에 산삼 있다
        // 3가지 종류의 점프

        // 작은 점프, 큰 점프, 매우 큰 점프
        // 매우 큰 점프는 단 한번만, 이때는 무조건 k만큼의 에너지를 소비

        // 점프 할 때는 에너지 소비, 작은 점프와 큰 점프시 소비되는 에너지는 점프를 하는 돌의 번호마다 다르다.

        int n = sc.nextInt();


        int[] smallJump = new int[n + 1];
        int[] bigJump = new int[n + 1];

        for (int i = 1; i <= n - 1; i++) {
            smallJump[i] = sc.nextInt();
            bigJump[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 1234567890);
        }

        dp[1][1] = 0;
        if (n == 1) {
            System.out.println(0);
            return;
        }

        dp[2][1] = smallJump[1];
        if (n == 2) {
            System.out.println(dp[2][1]);
            return;
        }

        for (int i = 3; i <= n; i++) {

            if (i <= 3) {
                dp[i][1] = min(dp[i - 1][1] + smallJump[i - 1], dp[i - 2][1] + bigJump[i - 2]);
            } else {
                dp[i][0] = min(dp[i - 1][0] + smallJump[i - 1], dp[i - 2][0] + bigJump[i - 2], dp[i - 3][1] + k);
                dp[i][1] = min(dp[i - 1][1] + smallJump[i - 1], dp[i - 2][1] + bigJump[i - 2]);
            }

        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));

    }

    public static int min(int a, int b, int c) {

        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        return Collections.min(list);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }


}