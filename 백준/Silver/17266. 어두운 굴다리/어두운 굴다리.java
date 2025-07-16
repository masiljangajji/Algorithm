import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0 ~ N 의 모든 길을 밝히게 가로등을 설치해 달라

        // 가로등을 설치할 개수 M과 가로등의 위치 x들의 결정을 끝냈다.
        // 각 가로등은 높이만큼 주위를 비출 수 있다.

        // 최소한의 높이로 모든길을 밝히고 싶다
        // 가로등은 모두 높이가 같아야 하고, 정수

        // 가로등의 높이가 H 라면 왼쪾으로 H,오른쪽만큼 H 를 비춤

        int n, m, x;

        n = sc.nextInt();
        m = sc.nextInt();
        // 가로등 위치는 오름차순

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = n;
        int ans = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            int prev = 0;
            boolean flag = false;

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] - mid <= prev) {
                    prev = arr[i] + mid;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag || n - prev > 0) { // 불빛 더 커져야 함
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);

    }


}


