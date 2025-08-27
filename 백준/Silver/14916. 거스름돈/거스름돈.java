import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


        // 2원짜리 , 5원짜리로 거스름돈

        // 동전 개수가 최소가 되도록 거슬러 주어야 한다

        // 거스름돈이 n인 경우, 최소 동전 개수를 출력

        int n = sc.nextInt();


        // 5로 나눈 나머지가 1,3 이면 n%5 한거에 +5

        // 5로 나눈 나머지가 2,4 면 n%5 그냥 하고 2로 처리

        int remain = n % 5;

        int answer = 0;

        if (n >= 5) {
            if (remain == 1 || remain == 3) {
                answer += n / 5;
                answer--;
                remain += 5;
                answer += (remain / 2);
            } else if (remain == 2 || remain == 4) {
                answer += n / 5;
                answer += (remain / 2);
            } else {
                answer += n / 5;
            }

            System.out.println(answer);
        } else {
            if (n % 2 == 0) {
                System.out.println(n / 2);
            } else {
                System.out.println(-1);
            }
        }


    }

}


