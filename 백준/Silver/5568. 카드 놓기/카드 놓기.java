import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Boolean> m = new HashMap<>();
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner((System.in));

        int n, k;

        n = Integer.parseInt(sc.nextLine());
        k = Integer.parseInt(sc.nextLine());

        visited = new boolean[n];

        // 1 이상 99이하의 정수가 적혀져 있다.
        // n개 에서 K개를 선택해 특정 정수를 만드는 문제, 순서 필요 -> 순열

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        StringBuilder stb = new StringBuilder();
        permutation(arr, stb, visited, 0, k);

        System.out.println(answer);
    }

    static void permutation(String[] arr, StringBuilder stb, boolean[] visited, int cnt, int size) {

        if (cnt == size) {
            String number = stb.toString();

            if (m.containsKey(number)) {
                return;
            }
            m.put(number, true);
            answer++;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i])
                continue;

            visited[i] = true;
            stb.append(arr[i]);
            permutation(arr, stb, visited, cnt + 1, size);
            visited[i] = false;
            int idx = stb.lastIndexOf(arr[i]);
            stb.delete(idx, idx + arr[i].length());
        }
    }

    static void combi(int start, String[] arr, StringBuilder stb, int cnt, int size) {

        if (cnt == size) {
            String number = stb.toString();

            if (m.containsKey(number)) {
                return;
            }
            System.out.println(number);
            m.put(number, true);
            answer++;
        }

        for (int i = start + 1; i < arr.length; i++) {
            stb.append(arr[i]);
            combi(i, arr, stb, cnt + 1, size);
            int idx = stb.lastIndexOf(arr[i]);
            stb.delete(idx, idx + arr[i].length());
        }
    }
}