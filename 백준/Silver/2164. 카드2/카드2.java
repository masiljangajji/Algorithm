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

        // 제일 위에 있는 카드를 버린다
        // 위에 있는 카드를 아래에 있는 카드 밑으로 옮긴다

        //N =4 , 1234 순서
        // 1을 버리면 234가 ㄴ마는다
        // 2를 아래로 옮기면 342가 된다

        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        boolean flag = true;

        while (q.size() > 1) {

            if (flag) {
                q.poll();
                flag = false;
            } else {
                int num = q.poll();
                q.offer(num);
                flag = true;
            }
        }


        System.out.println(q.peek());


    }


}







