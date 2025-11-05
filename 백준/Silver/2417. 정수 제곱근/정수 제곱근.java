import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long start = 0;
        long end = n;

        // 어떤수의 제곱이 n보다 크거나 같은, 가장 작은 정수

        while (start < end) {

            long mid = (start + end) / 2;

            if (Math.pow(mid, 2) < n) {
                start = mid + 1;
            } else { // 더 작다
                end = mid;
            }
        }

        System.out.println(start);
    }
}