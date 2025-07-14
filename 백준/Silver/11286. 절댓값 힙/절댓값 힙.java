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

        // N x N 표 , N^2 개 채우져 있음
        // 모든 수는 자신의 한 칸 위에 있는 수보다 크다
        // N번째로 큰 수를 찾는 프로그램

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                int absO1 = Math.abs(o1);
                int absO2 = Math.abs(o2);

                if (absO1 == absO2) {
                    return o1 - o2;
                }
                return absO1 - absO2;
            }
        });

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int x = sc.nextInt();

            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(x);
            }

        }


    }


}







