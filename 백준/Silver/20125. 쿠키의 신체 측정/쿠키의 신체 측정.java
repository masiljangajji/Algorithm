import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static int n;

    public static void main(String[] args) throws IOException {


        /**
         *
         * N
         * a1,1 . . . a1,N
         * . . . . . .
         * aN,1 . . . aN,N
         *
         */


        // 쿠키런 전파
        // 쿠키들 신체 측정
        // 머리, 심장, 허리, 팔, 다리 구성
        // 머리는 가장 위 칸 1칸 크키
        // 그 아래가 심장
        // 허리는 심장 아래로 쭉 뻗어있음
        // 각 신체 부위들은 절대 끊겨있지 않음


        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        int middle;
        int leftHand;
        int rightHand;
        int leftLeg;
        int rightLeg;


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }


        Pair heart = null;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i].charAt(j) == '*') {
                    heart = new Pair(i + 1, j);

                    middle = countMiddle(arr, i, j);
                    leftHand = countHand(arr, heart.y, heart.x, false);
                    rightHand = countHand(arr, heart.y, heart.x, true);

                    // 심장 + middle = 허리 끝

                    leftLeg = countLeg(arr, heart.y + middle + 1, heart.x - 1);
                    rightLeg = countLeg(arr, heart.y + middle + 1, heart.x + 1);

                    // 허리 끝 +1 y좌표에서 x좌표 +1 -1 하면 다리 시작

                    System.out.println(heart.y + 1 + " " + (heart.x + 1));
                    System.out.println(leftHand + " " + rightHand + " " + middle + " " + leftLeg + " " + rightLeg);
                    return;
                }

            }
        }

        // * 신체, _ 신체 아님

    }

    public static int countMiddle(String[] arr, int i, int j) {

        int count = 0;

        for (int p = i + 2; ; p++) { // x좌표는 그대로 y좌표만 움직여야 함
            if (arr[p].charAt(j) == '*') {
                count++;
                continue;
            }

            return count;
        }
    }

    public static int countLeg(String[] arr, int i, int j) {

        int count = 0;
        for (int p = i; ; p++) {
            if (p < n && arr[p].charAt(j) == '*') {
                count++;
                continue;
            }
            return count;
        }

    }

    public static int countHand(String[] arr, int i, int j, boolean dir) {

        int count = 0;

        // y좌표는 그대로 x좌표만 움직여야 함

        if (dir) {
            for (int p = j + 1; ; p++) {
                if (p < n && arr[i].charAt(p) == '*') {
                    count++;
                    continue;
                }
                return count;
            }
        }

        for (int p = j - 1; ; p--) {
            if (p >= 0 && arr[i].charAt(p) == '*') {
                count++;
                continue;
            }
            return count;
        }

    }

}


class Pair {

    int x;
    int y;

    Pair(int y, int x) {
        this.x = x;
        this.y = y;
    }

}
