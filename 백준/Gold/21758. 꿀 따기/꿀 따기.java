import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 개의 장소

        // 벌이 두마리, 하나는 고정
        // 왜? 시작지점에있는건 있어야함
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1];
        
        arr[1] = Integer.parseInt(st.nextToken());
        sum[1] = arr[1];

        int idx = 2;
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            arr[idx] = number;
            sum[idx] = sum[idx - 1] + number;
            idx++;
        }


        long answer = 0;

        for (int i = 2; i < n; i++) {

            answer = Math.max(answer, (sum[n] - arr[1] - arr[i]) + (sum[n] - sum[i]));
            answer = Math.max(answer, (sum[n - 1] - arr[i]) + sum[i - 1]);
            answer = Math.max(answer, sum[i] - arr[1] + (sum[n - 1] - sum[i - 1]));
        }

        System.out.println(answer);

    }

}

