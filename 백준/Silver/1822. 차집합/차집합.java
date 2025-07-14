import javax.swing.*;
import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static int SIZE_OF_A;

    public static int SIZE_OF_B;

    public static void main(String[] args) throws IOException {


        // 집합 A,B
        // A - B 를 구하라

        Scanner sc = new Scanner(System.in);

        SIZE_OF_A = sc.nextInt(); // A 원소 개수
        SIZE_OF_B = sc.nextInt(); // B 원소 개수


        int[] A = new int[SIZE_OF_A];
        int[] B = new int[SIZE_OF_B];

        for (int i = 0; i < SIZE_OF_A; i++) {
            A[i] = sc.nextInt();
        }

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < SIZE_OF_B; i++) {
            int num = sc.nextInt();
            B[i] = num;
            m.put(num, 1);
        }
        // A에는 속하면서, B에는 없는거
        // B에 있는 모든 원소 체크
        Arrays.sort(A);

        int cnt = 0;
        StringBuilder stb = new StringBuilder();
        boolean flag = true;

        for (int i = 0; i < SIZE_OF_A; i++) {
            if (m.getOrDefault(A[i], 0) == 0) {
                cnt++;
                stb.append(A[i] + " ");
                flag = false;
            }
        }

        if (flag)
            System.out.println(0);
        else {
            System.out.println(cnt);
            System.out.println(stb);
        }

    }


}




