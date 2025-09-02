import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        String number = br.readLine();
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < number.length(); i++) {

            char ch = number.charAt(i);

            if (st.isEmpty()) {
                st.push(ch);
                continue;
            }

            while (!st.isEmpty() && st.peek() < ch && cnt < k) {
                st.pop();
                cnt++;
            }

            st.push(ch);
        }

        while (cnt < k) {
            st.pop();
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb.reverse());

    }

}