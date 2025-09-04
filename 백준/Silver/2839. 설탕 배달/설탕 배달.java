import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N킬로그램 배달
        // 3킬로, 5킬로 봉지 있음

        // 최대한 적은 봉지를 들고 간다

        int n = Integer.parseInt(br.readLine());

        int min = 123456789;


        if (n % 5 == 0) {
            System.out.println(n / 5);
            return;
        }

        if (n % 3 == 0) {
            min = Math.min(n / 3, min);
        }

        // 5나 3으로 조합해서 풀어야 함

        int five = 0;

        while (n >= 5) {
            n -= 5;
            five++;

            if (n % 3 == 0) {
                min = Math.min(five + n / 3, min);
            }
        }

        if (n % 3 == 0) {
            min = Math.min(n / 3 + five, min);
        }

        if (min == 123456789) {
            System.out.println(-1);
        } else
            System.out.println(min);

    }

}