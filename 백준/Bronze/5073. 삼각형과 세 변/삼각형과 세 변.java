import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        /**
         *
         * Equilateral :  세 변의 길이가 모두 같은 경우
         * Isosceles : 두 변의 길이만 같은 경우
         * Scalene : 세 변의 길이가 모두 다른 경우
         * Invalid , 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않은경우
         */


        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, c;

            int max = -1;
            int sum = 0;

            a = Integer.parseInt(st.nextToken());
            max = Math.max(max, a);
            b = Integer.parseInt(st.nextToken());
            max = Math.max(max, b);
            c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);

            sum = a + b + c;

            if (a == 0 && b == 0 && c == 0) {
                return;
            }


            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (max >= sum - max) {
                System.out.println("Invalid");
            } else if (a != b && b != c && a != c) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }

        }


    }
}

