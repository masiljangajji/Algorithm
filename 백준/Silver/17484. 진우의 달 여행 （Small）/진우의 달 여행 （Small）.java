import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    public static int[][] arr = new int[7][7];

    public static int min = 123456789;
    public static int sum = 0;

    public static int n;
    public static int m;

    // 3방향의 좌표이동이 필요

    public static int[] dx = {-1, 0, 1};
    public static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {

        // N x M 행렬
        // 왼쪽 대각선 아래, 오른쪽 대각선 아래, 아래 3방향으로 움직인다.

        // 최소한의 시행으로 도착하는 것

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        // y좌표 0 은 지구에서 시작하는 것으로 보겠음
        // y좌표 n+1 은 달에 도착한것으로 보겠음


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) { // 방향
                dfs(0, i, j, 0);
            }
        }

        System.out.println(min);

    }

    public static void dfs(int y, int x, int currentDir, int sum) {

        for (int i = 0; i < 3; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || nx >= m) { // 맵 범위 밖임
                continue;
            }

            if (i == currentDir) { // 방향이 달라야 함
                continue;
            }

            if (ny == n + 1) { // 달에 도착하면
                min = Math.min(sum, min);
                return;
            }

            dfs(ny, nx, i, sum + arr[ny][nx]);

        }


    }


}
