import java.util.*;
import java.lang.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String str = sc.next();

        Map<Character, Integer> m = new TreeMap<>();

        for (char ch : str.toCharArray()) {
            m.put(ch, m.getOrDefault(ch, 0) + 1);
        }

        int cnt = 0;

        StringBuilder st = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        char odd = '1';

        for (char ch : m.keySet()) {

            int num = m.get(ch);

            if (num % 2 != 0) {
                cnt++;
                odd = ch;
                if (cnt == 2) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
            }

            for (int p = 0; p < m.get(ch) / 2; p++) {
                st.append(ch);
                reverse.append(ch);
            }

        }


        if (cnt == 1) {
            st.append(odd);
        }

        st.append(reverse.reverse());
        System.out.println(st);

    }

}