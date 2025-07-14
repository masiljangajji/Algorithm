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

        // 숫자 카드 n개, 정수 M개

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), 1);
        }

        int m = sc.nextInt();
        // 상근이가 가지고 있는 숫자 카드인지 아닌지, 구해야 할 M개의 정수


        int[] diff = new int[m];
        for (int i = 0; i < m; i++) {
            diff[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if (map.containsKey(diff[i])) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }


        // 이중 for 돌려서 완탐하면 해결되는 문제 -> 50만 x 50만 너무 큼
        // map 이용해서 처리 가능해 보임


    }


}




