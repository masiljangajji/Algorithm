import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // + -
        // 한번 - 나오면 다음 - 까지 괄호로 묶어버리기

        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str, "+-", true);


        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        while (stk.hasMoreTokens()) {

            String s = stk.nextToken();

            if (s.equals("+") || s.equals("-")) { // 앞에 - 있으면 계속 더하기 , 없으면 그냥 더하기
                operators.add(s);
                continue;
            }

            numbers.add(Integer.parseInt(s));
        }

        int sum = 0;
        int current = 0;
        boolean flag = false;
        int j = 0;
        sum += numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {

            j++;

            if (operators.get(i).equals("+")) {

                if (flag) { // 앞에 - 있으면
                    current += numbers.get(j);
                } else {
                    sum += numbers.get(j);
                }
            } else { // - 앞에 나왔음
                flag = true;
                current += numbers.get(j);
            }

        }

        if (flag) {
            sum -= current;
        }
        System.out.println(sum);

    }

}


