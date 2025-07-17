import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = sc.nextInt();

        boolean[] arr = new boolean[n + 4];

        boolean flag = false;

        // dp[n] == true 는 , n개 일때 현재 사람이 이길 수 있음

        arr[1] = true;
        arr[2] = false;
        arr[3] = true;

        for (int i = 4; i <= n; i++) {
            // dp[i-1] 이 false, dp [i-3] 이 false 면 이길 수 있음
            arr[i] = !arr[i - 1] || !arr[i - 3];
        }

        System.out.println(arr[n] ? "SK" : "CY");



    }
}
