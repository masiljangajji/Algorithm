import javax.swing.*;
import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0 부르면 쓴 수를 지운다

        int k = sc.nextInt();

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();

            if (num != 0) {
                stk.push(num);
            } else {
                stk.pop();
            }
        }

        int sum = 0;
        while (!stk.isEmpty()) {
            sum += stk.pop();
        }

        System.out.println(sum);

    }


}







