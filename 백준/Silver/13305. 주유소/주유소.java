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

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        // 각 도시의 기름 비용을 알면 됨, 지금이 가장 싸면 다 채우고
        // 2번째로 싸면, 1번째로 싼 곳 나오기 전까지 충전하고, 나머지는 1번쨰로 싼 곳으로 가는거

        int current = 0;
        int next = 0;
        int totalPrice = 0;
        int i = 0;
        prices[n - 1] = 123456789;

        while (current < cities.length) {
            next = current + 1;

            // System.out.println(current + " " + i + " " + totalPrice);

            if (prices[current] >= prices[next]) { // 다음 도시가 더 싸거나 같으면 최소한으로
                totalPrice += prices[current] * cities[i];
                current++;
                i++;
                continue;
            }

            // 다음 도시가 더 비싸면 지금 도시에 다다음 도시까지 충전
            while (next < n && prices[current] < prices[next]) {
                totalPrice += prices[current] * cities[i];
                i++;
                next++;
            }
            current = next;

        }

        //System.out.println(current + " " + i + " " + totalPrice);
        System.out.println(totalPrice);

    }

}
