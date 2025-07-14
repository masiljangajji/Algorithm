import javax.swing.*;
import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // N 개의 수로 된 수열
        // i,j 까지 합이 M이되는 경우의 수를 구하기

        // 최대값 3억 int 로 풀이

        Scanner sc = new Scanner(System.in);

        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 특정 구간의 합이 m이어야 함
        // 앞에서부터 left , right 두고 처리를 하기

        int left = 0;
        int right = -1;

        int sum = 0;
        int cnt = 0;

        int stop = 0;

        while (true) { // 조건 체크


            if (sum > m) { //
                sum -= arr[left];
                left++;
            } else if (sum < m) {
                right++;

                if (right >= n) {
                    break;
                }

                sum += arr[right];
            } else if (sum == m) {
                cnt++;
                sum -= arr[left];
                left++;
            }


        }

        System.out.println(cnt);

    }


}




