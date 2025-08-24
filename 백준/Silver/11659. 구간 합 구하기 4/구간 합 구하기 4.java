import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[100004];
        int[] sum = new int[100004];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            sum[i] = arr[i] + sum[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(sum[end] - sum[start - 1]);

        }


    }
}