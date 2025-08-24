import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[100004];
        int[] sum = new int[100004];

        st = new StringTokenizer(br.readLine());

        int idx = 1;
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            sum[idx] = arr[idx] + sum[idx - 1];
            idx++;
        }


        StringBuilder stb = new StringBuilder();
        int start;
        int end;
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            stb.append(sum[end] - sum[start - 1]).append("\n");
        }

        System.out.println(stb);


    }
}