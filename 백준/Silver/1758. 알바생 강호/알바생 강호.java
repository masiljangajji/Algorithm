import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // 8시까지 문앞에 줄 세운다
        // 8시가 되면 모두 입구에서 커피를 받고, 자리로 간다.

        // 자기가 커피를 몇 번째 받는지에 따라 팁을 준다

        // 원래 주려던 돈 - (받은 등수 -1), 음수면 팁 못바등ㅁ

        // 강호가 받을 수 있는 팁의 최댓 값을 구해라

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 최대값 = 0,-1을 만드는것을 최소화 한다.
        Arrays.sort(arr, Collections.reverseOrder());

        long sum = 0;
        int cnt = 1;

        for (Integer num : arr) {

            int result = num - (cnt - 1);
            if (result <= 0) {
                break;
            }

            sum += result;
            cnt++;
        }

        System.out.println(sum);

    }

}


