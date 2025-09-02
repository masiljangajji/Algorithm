import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //

        // 파일을 두 개씩 합쳐 나감
        // 합칠때 필요한 비용이, 두 파일의 크기의 합

        // 누적합이 최소가 되도록 만들겠다


        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            PriorityQueue<Long> pq = new PriorityQueue<>();

            int k = Integer.parseInt(br.readLine());
            long sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while (pq.size() > 1) {
                long total = pq.poll() + pq.poll();
                sum += total;
                pq.offer(total);
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }

}