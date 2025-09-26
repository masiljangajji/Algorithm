import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static int[] arr = new int[5001];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;

        n = sc.nextInt();
        k = sc.nextInt();

        // 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 K가 하나라도 포함되는 모든 시각을 세는 프로그램을 작성

        // 시, 분, 초

        // 시 3, 13, 23
        // 분 3, 30, 33
        // 초 3, 13, 30, 33,

        // 이 조합의 수를 나타내야 함

        long cnt = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int p = 0; p <= 59; p++) {

                    String time = String.format("%02d:%02d:%02d", j, i, p);
                    if (time.contains(String.valueOf(k))) {
                        cnt++;
                    }

                }
            }
        }

        System.out.println(cnt);


    }


}