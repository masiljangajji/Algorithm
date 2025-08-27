import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 운동기구 최대 두 개까지 선택
        // N개의 운동기구 한번씩 사용하길 원함

        // PT 받을 때마다 이전에 사용하지 않았던 운동기구 선택
        // PT 받을 때 가능하면 기구 2개 사용

        // PT 받을 때 근손실 정도가 M을 넘지 않도록 한다
        // M 의 최솟값을 구해라

        int n = sc.nextInt();

        Long[] arr = new Long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        } else if (n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }

        int start = 0;
        int end = n - 1;

        long max = 0;

        if (n % 2 != 0) {
            end--;
        }

        while (start < end) {
            max = Math.max(max, arr[start] + arr[end]);
            start++;
            end--;
        }

        System.out.println(max);



    }

}


