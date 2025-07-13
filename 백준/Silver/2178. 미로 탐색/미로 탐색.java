import java.util.*;
import java.lang.*;


public class Main {

    public static String[] arr = new String[104];
    public static int[][] visited = new int[104][104];
    public static int[] dy = {0, 0, -1, 1};
    public static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextLine();
        }

        // 1은 이동할 수 있는 칸
        // 0은 이동할 수 ㅇ벗는 칸

        // 1,1 에서 출발 N,M 위치로 이동
        // 지나야 하는 최소 칸 수 를 구해라, 인접한 칸만 이동 가능

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(1, 1));
        visited[1][1] = 1;

        while (!queue.isEmpty()) {

            Pair p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                // 범위 밖
                if (ny <= 0 || nx <= 0 || ny > N || nx > M) {
                    continue;
                }

                // 방문 체크
                if (visited[ny][nx] != 0) {
                    continue;
                }

                // 이동할 수 있는지 체크
                if (arr[ny].charAt(nx - 1) == '0') {
                    continue;
                }

                queue.add(new Pair(ny, nx));
                visited[ny][nx] = visited[p.y][p.x] + 1;
            }

        }

        System.out.println(visited[N][M]);

    }


}

class Pair {

    int y;
    int x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }


}