import java.util.*;

public class Main {

    static int MAX = 0;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner((System.in));

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] numbers = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    int sum = 0;
                    for (int p = 0; p < n; p++) {
                        int mx = numbers[p][i];
                        mx = Math.max(mx, numbers[p][j]);
                        mx = Math.max(mx, numbers[p][k]);
                        sum += mx;
                    }
                    MAX = Math.max(MAX, sum);
                }
            }
        }

        System.out.println(MAX);
    }


}