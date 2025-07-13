import java.util.*;
import java.lang.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static int[] visited = new int[1000004];

    public static void main(String[] args) {

        // F층 고층 건물
        // 목적지 위치는 G
        // 내가 있는 곳은 S
        // 엘베타고 G로 이동


        // F S G U D

        int f, s, g, u, d;

        f = sc.nextInt(); // 최대 값
        s = sc.nextInt(); // 내 위치
        g = sc.nextInt(); // 목적지
        u = sc.nextInt(); // 위로 u층 가거나
        d = sc.nextInt(); // 아래로 d층 가거나


        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = 1;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == g) {
                System.out.println(visited[now] - 1);
                return;
            }

            int up = now + u;
            int down = now - d;

            if (up <= f && visited[up] == 0) {
                visited[up] = visited[now] + 1;
                queue.add(up);
            }

            if (down >= 1 && visited[down] == 0) {
                visited[down] = visited[now] + 1;
                queue.add(down);
            }

        }

        System.out.println("use the stairs");

    }
}

