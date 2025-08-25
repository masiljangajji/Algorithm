import java.util.*;
import java.io.*;

class Main {

    public static long[] dp = new long[1000004];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t;

        t = sc.nextInt();

        // 정수 n을 1,2,3 의 합으로 나타내는 방법

        // dp[1] = 1  ->  1

        // dp[2] = (1+1), (2) -> 2

        // dp[3] = (1,1,1) , (1,2), (2,1) , (3) -> 4
        // dp[4] = (1,1,1,1), (1,2,1) , (2,1,1) , (1,1,2), (2,2) (1,3) , (3,1) -> 7
        // dp[5] = (1,1,1,1,1) , (2,1,1,1) , (1,2,1,1), (1,1,2,1), (1,1,1,2) , (2,2,1) , (2,1,2), (1,2,2) , (3,1,1), (3,2), (1,3,1) , (2,3), (1,1,3) -> 13

        // 1, 2, 4, 7, 13

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        dp();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(dp[list.get(i)]);
        }

    }

    public static void dp() {

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
    }


}
