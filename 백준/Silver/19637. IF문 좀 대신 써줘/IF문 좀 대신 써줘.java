import java.beans.Introspector;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {


        // 만 이하 WEAK
        // 만일 ~ 십만 NORMAL
        // 십만일 ~ 백만 STRONG

        // 첫 번째 줄에는 칭호의 개수 N  ( 10^5 , 100000 십만)
        // 칭호를 출력해야 하는 케릭터들의 수 M (십만)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(st.nextToken(), Integer.parseInt(st.nextToken()));
        }


        int number;

        // 전체순회 돌리면 되는데 100억번 이라 터질것 같음

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < m; i++) {

            number = Integer.parseInt(br.readLine());

            // 이분탐색으로 만족하는지 먼저 찾기

            int start = 0;
            int end = n - 1;
            String answer = "";

            while (start <= end) {
                int mid = (start + end) / 2;

                Pair pair = pairs[mid];

                if (number <= pair.limit) {
                    end = mid - 1;
                    answer = pair.name;
                }

                if (number > pair.limit) {
                    start = mid + 1;
                }
            }

            stb.append(answer).append("\n");
        }

        System.out.println(stb);

    }
}

class Pair {

    String name;
    int limit;

    public Pair(String name, int limit) {
        this.limit = limit;
        this.name = name;
    }


}




