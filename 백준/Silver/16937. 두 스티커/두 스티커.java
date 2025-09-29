import java.util.*;

public class Main {

    static int MAX = 0;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner((System.in));

        int h, w;

        // 크기ㅏ hxw 인 모눈종이와 스티커 N개, 스티커 크기는 rixci

        h = sc.nextInt();
        w = sc.nextInt();

        int n = sc.nextInt();

        // 크기가 딱 떨어지면 도형
        // 크기다 안떨어지면 도형이 둘 , 가로,세로


        int[][] arr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                Pair[] A = {new Pair(arr[i][0], arr[i][1]), new Pair(arr[i][1], arr[i][0])};
                Pair[] B = {new Pair(arr[j][0], arr[j][1]), new Pair(arr[j][1], arr[j][0])};

                for (Pair a : A) {
                    for (Pair b : B) {

                        if (Math.max(a.y, b.y) <= h && a.x + b.x <= w) {
                            answer = Math.max(answer, a.x * a.y + b.x * b.y);
                        }

                        if (Math.max(a.x, b.x) <= w && a.y + b.y <= h) {
                            answer = Math.max(answer, a.x * a.y + b.x * b.y);
                        }

                    }
                }

            }
        }

        System.out.println(answer);
    }

}

class Pair {

    int y, x;

    public Pair(int x, int y) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}