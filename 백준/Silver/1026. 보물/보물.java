import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        // 길이가 N인 정수배열 A,B
        // 함수 S를 정의

        // S = A x B 각 인덱스

        // S 값을 가장 작게 만들고 싶다, B는 재배열 불가능

        // 그럼 B가 가장 큰 값일 때, A의 값을 가장 작은걸 넣어주면 된다.

        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        Collections.sort(a);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        // 0 1 1 1 6
        // 8 7 3 2 1


        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a.get(i) * pq.poll();
        }
        System.out.println(sum);

    }


}


