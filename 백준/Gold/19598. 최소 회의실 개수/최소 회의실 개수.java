import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = sc.nextInt();

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(pairs, (p1, p2) -> p1.start == p2.start ? p1.end - p2.end : p1.start - p2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(pairs[0].end);

        for (int i = 1; i < n; i++) {

            if (pq.peek() <= pairs[i].start) {
                pq.poll();
            }
            pq.offer(pairs[i].end);
        }

        System.out.println(pq.size());


    }
}

class Pair {

    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

