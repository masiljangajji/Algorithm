import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] horseMoveX = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static int[] horseMoveY = {1, 2, 2, 1, -1, -2, -2, -1};

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int[][][] visited;


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[][] arr = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = sc.nextInt(); // 은 평지, 1은 장애물
            }
        }

        visited = new int[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, k));
        visited[0][0][k] = 0;

        if(h==1&&w==1){
            System.out.println(0);
            return;
        }
        
        while (!q.isEmpty()) {

            Pair p = q.poll();
            int y = p.y;
            int x = p.x;
            int horse = p.horse;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || nx >= w || ny >= h)
                    continue;

                if (visited[ny][nx][horse] != -1)
                    continue;

                if (arr[ny][nx] == 1)
                    continue;

                if (ny + 1 == h && nx + 1 == w) {
                    System.out.println(visited[y][x][horse] + 1);
                    return;
                }


                q.offer(new Pair(ny, nx, p.horse));
                visited[ny][nx][horse] = visited[y][x][horse] + 1;
            }

            if (horse <= 0)
                continue;

            for (int i = 0; i < 8; i++) {
                int ny = y + horseMoveY[i];
                int nx = x + horseMoveX[i];

                if (ny < 0 || nx < 0 || nx >= w || ny >= h)
                    continue;

                if (visited[ny][nx][horse - 1] != -1)
                    continue;

                if (arr[ny][nx] == 1)
                    continue;

                if (ny + 1 == h && nx + 1 == w) {
                    System.out.println(visited[y][x][horse] + 1);
                    return;
                }

                q.offer(new Pair(ny, nx, horse - 1));
                visited[ny][nx][horse - 1] = visited[y][x][horse] + 1;
            }

        }

        System.out.println(-1);


    }

    public static void prt(int h, int w, int[][] visited) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.printf("%3d ", visited[i][j]);
            }
            System.out.println();
        }
    }
}

class Pair {

    int y;
    int x;
    int horse;

    public Pair(int y, int x, int horse) {
        this.y = y;
        this.x = x;
        this.horse = horse;
    }
}

