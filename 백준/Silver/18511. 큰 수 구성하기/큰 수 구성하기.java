import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static int[] K;
    static long best = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        K = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) K[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(K);

        dfs(0L);

        System.out.println(best);
    }

    static void dfs(long cur) {

        if (cur > best)
            best = cur;

        for (int d : K) {
            if (cur * 10 + d > N)
                continue;
            long next = cur * 10 + d;
            if (next <= N)
                dfs(next);
        }
    }


}