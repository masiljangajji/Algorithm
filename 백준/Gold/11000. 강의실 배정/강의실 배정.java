import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // 수업이 끝난 직후에 다음 수업을 시작할 수 있다.

        // 최소한의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Pair[] pairs = new Pair[n];

        int s, t;


        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            s = Integer.parseInt(stk.nextToken());
            t = Integer.parseInt(stk.nextToken());
            pairs[i] = new Pair(s, t);
        }

        Arrays.sort(pairs, (p1, p2) -> p1.start == p2.start ? p1.end - p2.end : p1.start - p2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(pairs[0].end);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= pairs[i].start) { // end 보다 start가 더 크거나 같으면
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

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

}