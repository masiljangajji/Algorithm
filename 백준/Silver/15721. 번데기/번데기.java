import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> m = new HashMap<>();
    static int bCount = 0;
    static int dCount = 0;
    static int totalCount = -1;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // 게임 진행하는 사람 수
        int a = sc.nextInt();
        // t번째 등장하는
        int t = sc.nextInt();
        // 뻔 혹은 데기
        int check = sc.nextInt();

        int gen = 1;
        while (totalCount <= 10000) {
            generate(gen);
            gen++;
        }

        int cnt;
        if (check == 0) {
            cnt = m.get(t * -1);
        } else {
            cnt = m.get(t);
        }

        if (cnt % a == 0) {
            System.out.println(0);
        } else {
            System.out.println(cnt % a);
        }

    }

    static void generate(int n) {

        // 4 + (n+1)*2
        m.put(--bCount, ++totalCount);
        m.put(++dCount, ++totalCount);
        m.put(--bCount, ++totalCount);
        m.put(++dCount, ++totalCount);

        for (int i = 0; i <= n; i++)
            m.put(--bCount, ++totalCount);

        for (int i = 0; i <= n; i++)
            m.put(++dCount, ++totalCount);
    }

}