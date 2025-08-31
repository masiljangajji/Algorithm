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


        // N개의 센서, 도로위에 K개의 집중국

        // 센서중 하나는 집중국과 연결, 거리의 합이 최소
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] sensors = new int[n];
        for (int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors);
        int start = sensors[0];
        int end = sensors[sensors.length - 1];

        if (end - start <= k) {
            System.out.println(0);
            return;
        }

        Integer[] diff = new Integer[n - 1];

        for (int i = 0; i < sensors.length - 1; i++) {
            diff[i] = Math.abs(sensors[i] - sensors[i + 1]);
        }
        Arrays.sort(diff, Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += diff[i];
        }

        System.out.println((end - start) - sum);

    }
}
// 3, 20
// 18/5 ->

