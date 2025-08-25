import java.util.*;
import java.io.*;

class Main {

    public static int[][] arr = new int[104][104];
    public static int[][] check = new int[104][104];
    public static int[][] region = new int[104][104];
    public static boolean[][] visited = new boolean[104][104];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int MIN = 123456789;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        int cnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 1 && !visited[i][j]) { // 방문안했고, 육지면 영역 스캔
                    regionBfs(n, i, j, cnt);
                    cnt++;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf("%3d ", region[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 1)
                    bfs(n, i, j);
            }
        }

        System.out.println(MIN - 1);

    }

    public static void bfs(int n, int y, int x) {

        boolean[][] visited = new boolean[104][104];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x, 0});
        visited[y][x] = true;
        int regionValue = region[y][x];

        while (!queue.isEmpty()) {

            int[] pair = queue.poll();

            for (int i = 0; i < 4; i++) {

                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                int cost = pair[2] + 1;

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) // 범위 밖
                    continue;

                if (visited[ny][nx]) // 이미 방문
                    continue;

                if (arr[ny][nx] == 1) { // 육지임
                    if (region[ny][nx] != regionValue) { // 영역이 다름
                        // System.out.println(ny + " " + nx + " " + cost + " " + regionValue);
                        MIN = Math.min(MIN, cost); // 다리 길이 체크
                    }
                    continue;
                }

                queue.add(new int[]{ny, nx, cost});
                visited[ny][nx] = true;
            }

        }
    }

    public static void regionBfs(int n, int y, int x, int cnt) {


        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x});
        visited[y][x] = true;
        region[y][x] = cnt;

        while (!queue.isEmpty()) {

            int[] pair = queue.poll();

            for (int i = 0; i < 4; i++) {

                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) // 범위 밖
                    continue;

                if (visited[ny][nx]) // 이미 방문
                    continue;

                if (arr[ny][nx] == 0) // 바다임
                    continue;

                region[ny][nx] = cnt;
                queue.add(new int[]{ny, nx});
                visited[ny][nx] = true;
            }

        }

    }


}
