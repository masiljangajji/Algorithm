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

        int n = Integer.parseInt(br.readLine());

        // 사람들끼리의 거리의 합이 최소가 되는 위치에 우체국

        Pair[] pairs = new Pair[n];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            int home = Integer.parseInt(strs[0]);
            int people = Integer.parseInt(strs[1]);
            sum += people;
            pairs[i] = new Pair(home, people);
        }

        // 집 위치 오름차순 정렬
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.home));
        // 일단 거리의 합이 최소가 되려면, 많은 사람들이 사는 마을 근처에 있어야 함


        long current = 0;
        for (Pair p : pairs) {
            current += p.people;
            if (sum - current <= current) {
                System.out.println(p.home);
                return;
            }
        }

    }
}


class Pair {

    int home;
    int people;

    Pair(int home, int people) {
        this.home = home;
        this.people = people;
    }

}


