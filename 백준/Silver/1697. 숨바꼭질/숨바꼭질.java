import java.util.*;
import java.lang.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static int[] visited = new int[100004];

    public static void main(String[] args) {


        // 0 <= N <= 100,000 십만

        // 수빈이 걷거나 순간이동 함
        // 수빈이 위치 X일때 걷는다면 1초후 X-1 or X+1 이동
        // 순간이동 하는경우 2*x 위치로 이동

        // 동생 찾는 가장 빠른 시간

        // 완탐 문제

        // 갈래는 항상 2갈래 , 1칸이동 Or 순간이동
        // bfs 로 풀어보기

        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        Arrays.fill(visited, -1);
        visited[n] = 0;


        while (!queue.isEmpty()) {

            int idx = queue.poll();

            if (idx == k) {
                System.out.println(visited[idx]);
                return;
            }

            int plusIdx = idx + 1;
            int minusIdx = idx - 1;
            int mulIdx = idx * 2;

            if (plusIdx <= 100000 && visited[plusIdx] == -1) {
                visited[plusIdx] = visited[idx] + 1;
                queue.add(plusIdx);
            }

            if (minusIdx >= 0 && visited[minusIdx] == -1) {
                visited[minusIdx] = visited[idx] + 1;
                queue.add(minusIdx);
            }

            if (mulIdx <= 100000 && visited[mulIdx] == -1) {
                visited[mulIdx] = visited[idx] + 1;
                queue.add(mulIdx);
            }

        }

    }
}

