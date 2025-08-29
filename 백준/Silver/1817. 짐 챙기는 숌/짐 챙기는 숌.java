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

        // 책은 무게가 있음
        // 필요한 박스의 최솟값

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        int idx = 0;

        while (idx < n) {

            int max = m;
            cnt++;

            while (idx < n) {

                if (max - arr[idx] >= 0)
                    max -= arr[idx];
                else
                    break;
                idx++;
            }

        }
        System.out.println(cnt);

    }

}


