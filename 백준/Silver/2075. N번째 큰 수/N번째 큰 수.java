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

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(sc.nextInt());
            }
        }

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());


    }


}







