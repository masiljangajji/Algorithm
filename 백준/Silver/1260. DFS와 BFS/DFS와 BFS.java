import java.util.*;
import java.lang.*;


public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int N = sc.nextInt();
    public static int M = sc.nextInt();
    public static int V = sc.nextInt();
    public static boolean[] visited = new boolean[N + 10];


    public static void main(String[] args) {

        List<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(graph, V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(graph, V);

        // V 부터 방문된 점을 순서대로 출력하면 된다.
    }


    public static void dfs(List<Integer>[] graph, int v) { // now index

        System.out.print(v + " ");
        List<Integer> list = graph[v];
        visited[v] = true;

        for (int i = 0; i < list.size(); i++) {

            int num = list.get(i);

            if (visited[num])
                continue;


            visited[num] = true;
            dfs(graph, num);
        }
    }

    public static void bfs(List<Integer>[] graph, int v) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        System.out.print(v + " ");
        visited[v] = true;

        while (!queue.isEmpty()) {

            int num = queue.poll();
            List<Integer> list = graph[num];

            for (int i = 0; i < list.size(); i++) {

                int n = list.get(i);

                if (visited[n])
                    continue;

                visited[n] = true;
                System.out.print(n + " ");

                queue.add(n);
            }
        }

    }


}