import javax.swing.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 사람은 1번부터 N번까지 번호가 매겨져 있다
        // i 번 사람이 인출하는데 걸리는 시간 P[i]


        // 3,1,4,3,2
        // 3+4+8+11+13 = 39
        // 1 2 3 4 5 순서

        // 2 5 1 4 3 순서
        // 1,2,3,3,4
        // 1+3+6+9+13

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        Arrays.sort(arr);

        int sum = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            total += sum;
        }

        System.out.println(total);

    }


}


