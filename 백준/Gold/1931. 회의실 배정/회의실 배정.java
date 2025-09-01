import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 개의 회의
        // I에 대해 시작시간, 끝나는 시간

        int n = sc.nextInt();

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(pairs, (p1, p2) -> p1.end == p2.end ? p1.start - p2.start : p1.end - p2.end);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(pairs[0].end);
        int cnt = 1;

        for (int i = 1; i < n; i++) {

            //System.out.println(pq.peek() + " " + pairs[i].start);

            if (pq.peek() <= pairs[i].start) {
                cnt++;
                pq.poll();
                pq.offer(pairs[i].end);
            }
        }

        System.out.println(cnt);

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

