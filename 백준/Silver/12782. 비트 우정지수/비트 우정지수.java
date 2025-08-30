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

        // 비트 우정지수
        // 10 진법으로 나타낸 두 정수를 , 이진수로 나타내었을 때
        // 두 숫자를 같게 만드는데 필요한 최소 연산 횟수

        // 하나의 이진수에서 임의의 자리의 숫자를 0 또는 1로 바꾼다.
        // 하나의 이진수에서 서로 다른 자리에 있는 두 숫자의 위치를 바꾼다.

        // 1011
        // 1100

        // 가능하다면
        // 하나의 이진수에서 서로 다른 자리에 있는 두 숫자의 위치를 바꾼다., 이걸 해야겠네
        // 이게 안되면, 1번을

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i <= n; i++) {

            StringTokenizer stk = new StringTokenizer(br.readLine());

            String str1 = stk.nextToken();
            String str2 = stk.nextToken();

            int cnt1 = 0;
            int cnt2 = 0;
            for (int j = 0; j < str1.length(); j++) {

                if (str1.charAt(j) != str2.charAt(j)) {

                    if (str1.charAt(j) == '1') { // str1이 1 Str2가 0
                        cnt1++;
                    } else {
                        cnt2++; // str1이 0 str2가 1
                    }
                }

            }

            System.out.println(Math.min(cnt1, cnt2) + Math.abs(cnt1 - cnt2));

        }

    }

}


