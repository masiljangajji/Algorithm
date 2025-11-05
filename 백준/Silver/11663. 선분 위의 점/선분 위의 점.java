import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dots = new int[n];

        for (int i = 0; i < n; i++) {
            dots[i] = sc.nextInt();
        }

        Arrays.sort(dots);

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(getLastIndex(dots, end) - getStartIndex(dots, start));
        }
    }

    private static int getStartIndex(int[] dots, int num) {

        int start = 0;
        int end = dots.length - 1;

        if (dots[end] <= num) {
            return end + 1;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            // num 보다 크거나 같은, 가장 작은 인덱스
            if (dots[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getLastIndex(int[] dots, int num) {

        int start = 0;
        int end = dots.length - 1;

        if (dots[end] <= num)
            return end + 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            // num 보다 큰, 가장 작은 인덱스
            if (dots[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}

