import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int[] fibo = new int[2000004];

        int middle = 1000000;
        int n = sc.nextInt();

        fibo[middle - 1] = 1;
        fibo[middle] = 0;
        fibo[middle + 1] = 1;


        for (int i = 2; i <= Math.abs(n); i++) {
            fibo[i + middle] = (fibo[i + middle - 1] + fibo[i + middle - 2]) % 1000000000;
            fibo[middle - i] = (fibo[middle - i + 2] - fibo[middle - i + 1]) % 1000000000;
        }


//        f(n - 2) = f(n) - f(n - 1);

        int number = fibo[n + middle];
        if (number < 0) {
            System.out.println(-1);
        } else if (number == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
        System.out.println(Math.abs(fibo[n + middle]));


    }
}