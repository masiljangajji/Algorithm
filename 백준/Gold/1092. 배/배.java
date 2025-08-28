import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        /**
         *
         * 각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다. 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램을 작성하시오.
         */


        int n = Integer.parseInt(br.readLine());
        Integer[] crain = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(crain, Comparator.reverseOrder());
        box.sort(Comparator.reverseOrder());

        if (box.get(0) > crain[0]) {
            System.out.println(-1);
            return;
        }



        int cnt = 0;

        while (!box.isEmpty()) {

            int i = 0; // 크레인
            int j = 0; // 박스
            cnt++;

            while (i < crain.length && j < box.size()) {
                if (crain[i] >= box.get(j)) {
                    box.remove(j);
                    i++;
                    continue;
                }
                j++;
            }
        }

        System.out.println(cnt);

    }

}


