import java.util.*;
import java.io.*;

class Main {

    public static int min = 1234567890;
    public static int max = -1234567890;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // N 개의 수
        // 사이에 끼워넣을 수 있는 N-1 개의 연산자

        // 수와 수 사이에 연산자를 넣어 수식을 만들 수 있음

        int n = sc.nextInt();

        int[] arr = new int[104];
        int[] op = new int[4];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt(); // + , - , x , /
        }

        dfs(arr[0], 1, arr, op);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int number, int arrIdx, int[] arr, int[] op) {

        boolean flag = false;

        for (int i = 0; i < 4; i++) {

            if (op[i] != 0) {

                int result = 0;

                flag = true;

                switch (i) {

                    case 0:
                        result = number + arr[arrIdx];
                        break;
                    case 1:
                        result = number - arr[arrIdx];
                        break;
                    case 2:
                        result = number * arr[arrIdx];
                        break;
                    case 3:
                        result = number / arr[arrIdx];
                        break;
                }

                op[i]--;
                dfs(result, arrIdx + 1, arr, op);
                op[i]++;
            }

        }

        if (!flag) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }


    }

}