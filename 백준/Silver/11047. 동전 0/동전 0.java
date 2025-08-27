import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전을 조합해서 가치의 합을 k로 만든다
        // 필요한 개수의 최솟값을 구하는 프로그램

        int[] arr = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            idx = i;
            if (num >= k) {
                break;
            }
        }

        int cnt = 0;
        for (int i = idx; i >= 0; i--) {

            cnt += k / arr[i];
            k = k % arr[i];

            if(k==0){
                break;
            }

        }

        System.out.println(cnt);

    }

}


