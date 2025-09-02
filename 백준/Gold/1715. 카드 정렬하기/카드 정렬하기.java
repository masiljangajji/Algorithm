import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 명의 원생들 키 순서대로 줄 세움

        // 가장 키가 큰 원생, 가장 키가 작은 원생

        // 티셔츠 비용은 가장 큰 키 - 가장 작은 키

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        long sum = 0;
        while (pq.size() >= 2) {

            int num1 = pq.poll();
            int num2 = pq.poll();
            sum += num1 + num2;
            pq.offer(num1 + num2);
        }

        System.out.println(sum);

    }

}

