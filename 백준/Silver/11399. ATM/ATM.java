import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람이 줄 서있다
        // 1번부터 N번까지 있다

        // i번 사람이 인출하는데 걸리는 시간은 Pi 분이다.

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 1 2 3 3 4

        // 1 2 3 3 4

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            answer += sum;
        }

        System.out.println(answer);

    }

}


