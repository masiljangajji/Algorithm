import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 시간 일하면 피로도 A, 일은 B만큼 처리
        // 한 시간 쉬면 C만큼 피로도 줄어듬

        // 피로도는 0이하로 내려가지 않음
        // 피로도 M을 넘지 않게 하려 함

        int a, b, c, m;

        a = sc.nextInt(); // 피로도
        b = sc.nextInt(); // 일 처리
        c = sc.nextInt(); // 쉬는
        m = sc.nextInt(); // 피로도 어퍼바운드

        int time = 0;
        int p = 0; // 처음 피로도

        int answer = 0;

        while (time < 24) {

            if (p + a <= m) {
                answer += b;
                p += a;
            } else {
                p = Math.max(0, p - c);
            }

            time++;
        }

        System.out.println(answer);

    }


}