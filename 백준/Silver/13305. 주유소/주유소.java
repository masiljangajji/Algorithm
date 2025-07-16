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

        // N 개의 도시
        // 0에서 N번째 도시로 이동

        // 도시마다 리터당 가격이 있음
        // 최소 비용 구하기

        int n = sc.nextInt();

        int[] cities = new int[n - 1]; // 도시 사이의 거리
        for (int i = 0; i < n - 1; i++) {
            cities[i] = sc.nextInt();
        }

        int[] prices = new int[n];
        int[] decreasePrices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        decreasePrices[0] = prices[0];
        int prev = prices[0];

        for (int i = 1; i < n; i++) {

            if (prev < prices[i]) {
                decreasePrices[i] = prev;
            } else {
                prev = prices[i];
                decreasePrices[i] = prev;
            }

        }

        long totalPrice = 0;
        for (int i = 0; i < n - 1; i++) {
            totalPrice += (long) decreasePrices[i] * cities[i];
        }

        System.out.println(totalPrice);

    }

}
