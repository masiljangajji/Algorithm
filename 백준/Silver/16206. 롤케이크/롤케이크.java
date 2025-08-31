import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이가 10인 것만 섭취
        // 10인 걸 최대한 만든다

        /**
         *
         * 자를 롤케이크를 하나 고른다. 길이가 1보다 큰 롤케이크만 자를 수 있다. 이때, 고른 롤케이크의 길이를 x라고 한다.
         * 0보다 크고, x보다 작은 자연수 y를 고른다.
         * 롤케이크를 잘라 길이가 y, x-y인 롤케이크 두 개로 만든다.
         *
         */

        int n, m;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (number >= 10) {
                if (number % 10 == 0) {
                    list.add(number);
                } else {
                    list2.add(number);
                }
            }
        }

        Collections.sort(list);

        int answer = 0;
        for (int num : list) {

            if (num == 10) {
                answer++;
            } else {
                int pieces = num / 10;
                int cuts = pieces - 1;

                if (m >= cuts) {
                    answer += pieces;
                    m -= cuts;
                } else {
                    answer += m;
                    m = 0;
                    break;
                }

            }
        }


        if (m > 0) {
            for (int num : list2) {

                int pieces = num / 10;
                if (pieces == 0)
                    continue;

                int use = Math.min(m, pieces);
                answer += use;
                m -= use;
                if (m == 0)
                    break;

            }
        }

        System.out.println(answer);

    }
}
