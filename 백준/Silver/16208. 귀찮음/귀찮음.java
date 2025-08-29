import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이 x+y인 막대를 x,y 두 개의 막대로 자를 때에는 xy 비용이 든다

        // 현우 최소의 비용으로 쇠마갣를 잘라서 n개를 얻는다

        int n = sc.nextInt();
        long[] arr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        long answer = 0;

        for (int i = 0; i < arr.length; i++) {
            // 길이 sum 짜리를, sum-arr[i], arr[i] 짜리 막대 둘로 나눈다
            answer += (sum - arr[i]) * arr[i];
            sum -= arr[i];
        }

        System.out.println(answer);
    }

}


