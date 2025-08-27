import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2+1 세일하는 행사
        // 3개를 한 번에 산다면 가장 싼건 무료
        // 한번에 3개씩 안사면 할인 없이 정가

        // 1. 무조건 3번씩 산다
        // 2. 3번씩 살 때 가장 높은 가격순으로 담는다

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt++;
            if (cnt == 3) {
                cnt = 0;
                continue;
            }
            sum += arr[i];
        }

        System.out.println(sum);

    }

}


