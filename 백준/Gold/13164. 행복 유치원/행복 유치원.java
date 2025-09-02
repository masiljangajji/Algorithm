import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 명의 원생들 키 순서대로 줄 세움

        // 가장 키가 큰 원생, 가장 키가 작은 원생

        // 티셔츠 비용은 가장 큰 키 - 가장 작은 키

        int n, k;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n <= k) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        long answer = 0;

        for (int i = 0; i < n - k; i++) {
            answer += diff[i];
        }
        System.out.println(answer);

    }

}

