import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 A를 B로

        // 2를 곱한다
        // 1을 가장 오른쪽에 추가한다

        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        int cnt = 0;

        if (a == b) {
            System.out.println(1);
            return;
        }

        while (b > 0) {

            cnt++;

            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 10 == 1) {
                b /= 10;
            } else {
                System.out.println(-1);
                return;
            }

            if (a == b) {
                System.out.println(cnt + 1);
                return;
            }

        }

        System.out.println(-1);

    }

}


