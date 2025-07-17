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
         * Y = 윷놀이, 2명이서
         * F = 그림 찾기, 3명이서
         * O = 원카드, 4명이서
         *
         * 인원수 맞춰줘야 함
         *
         * 같이 한 사람과는 다시 플레이 X
         * 동명이인은 없다
         *
         *
         */

        int n, k;

        n = sc.nextInt();
        k = sc.next().charAt(0);
        sc.nextLine();

        Set<String> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(sc.nextLine());
        }

        if (k == 'Y') { // 2명
            System.out.println(s.size());
        } else if (k == 'F') { // 3명
            System.out.println(s.size() / 2);
        } else if (k == 'O') {  // 4명
            System.out.println(s.size() / 3);
        }

    }
}

