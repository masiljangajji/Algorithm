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

        // 민겸 수
        // 10^N 꼴의 십진수는 N + 1개의 M
        // 5 x 10^N 꼴의 십진수는 N개의 M 뒤에 1개의 K를 이어붙임

        // 가장 큰 수
        // 가장 작은 수

        // 어차피 자릿수는 같음, 그러면?? -> MK 로 묶어줘야 함, 그래야 앞 자리에서 50이 나오니까
        // M 뒤에오는 K는 무조건 묶고, 쌓인 M 없이 K가 오면,5로 치환

        //

        String str = br.readLine();

        boolean flag = false;

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == 'M') {
                flag = true;
                current.append(ch);
            } else if (ch == 'K') {
                if (flag) { // 앞단에 M 존재

                    flag = false;

                    // 최대는 MK를 이어서 50을 만들고
                    // 최소는 M/K 로 만들어서 1,5 를 만들어
                    // K는 5야
                    max.append("5");
                    min.append("1");
                    for (int j = 1; j < current.length(); j++) {
                        max.append("0");
                        min.append("0");
                    }
                    max.append("0");
                    min.append("5");
                    current.delete(0, current.length());

                } else {
                    max.append("5");
                    min.append("5");
                }
            }

        }

        if (!current.toString().isEmpty()) {
            max.append("1");
            min.append("1");
            for (int i = 1; i < current.length(); i++) {
                max.append("1");
                min.append("0");
            }
        }


        System.out.println(max);
        System.out.println(min);

    }

}


