import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 로프를 병렬로 연결하면 로프에 걸리는 중량을 나눌 수 있다.
        // K개의 로프를 사용하면 w/k 만큼의 중량이 걸리게 된다.

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        int cnt = 0;

        int max = arr[0];
        int w = arr[0];

        // w/k 만큼 걸린게 최소값 보다 크거나 같으면 가능
        // w = 최솟값 k

        // w/k 가 arr[i]번째보다 크면 상관 없는거잖음

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (i + 1));
        }

        System.out.println(max);


    }

}


