import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         *
         * N일 동안 블로그 운영
         * X일 동안 가장 많이 들어온 방문자 수, 그 기간이 몇 개 있는지
         *
         */

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;
        int answer = 0;

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {

            if (i + 1 == x) { // 최초로 먹는 것
                sum += arr[i];
                max = sum;
                answer = 1;
            } else if (i + 1 > x) { // 이전 꺼 빼주고, 새로운 값 넣어주고
                sum -= arr[i - x];
                sum += arr[i];

                if (max < sum) {
                    max = sum;
                    answer = 1;
                } else if (max == sum) {
                    answer++;
                }
            } else {
                sum += arr[i];
            }

        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(answer);
        }


    }

}