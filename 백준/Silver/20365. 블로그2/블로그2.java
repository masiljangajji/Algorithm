import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 해결하면 파란색
        // 해결 못하면 빨간색

        // 연속된 임의의 문제 선택
        // 선택된 문제들을 같은 색으로 칠함

        // 한번 정한 구간은 모두 같은색으로만 칠한다

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();


        Map<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                m.merge(str.charAt(i), 1, Integer::sum);
            }
        }

        m.merge(str.charAt(str.length() - 1), 1, Integer::sum);

        //        System.out.println(m.get('R'));
        //        System.out.println(m.get('B'));

        System.out.println(1 + Math.min(m.getOrDefault('B', 0), m.getOrDefault('R', 0)));

    }

}


