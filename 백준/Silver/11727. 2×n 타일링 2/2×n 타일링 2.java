import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        // 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법의 수를 구하는 프로그램

        // 직사각형은 가로 혹은 세로로 새울 수 있음

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 1x2, 2x1, 2x2 타일로 채우는 방법의 수

        // 높이는 항상 2로 고정

        // 1x2 를 사용하려면 항상 2개를 묶어 써야 함
        // 1x2 를 묶어 사용하면 2x2 를 한개 사용한것과 동일해짐

        // 1x2, 2x2, 2x1 를

        // 17을 3종류로 채우자
        // [1][1][2]


        int[] dp = new int[1004];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;

        }

        System.out.println(dp[n]);

        // 숫자 x를 1과 2로만 구성
        // 1111
        // 112(2) 121(2) 211(2)
        // 22(4)

    }
}