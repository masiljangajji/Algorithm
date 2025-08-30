import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이가 L인 테이프 무한개

        // 위치의 좌우 0.5 만큼 간격을 줘야 물이 다시는 안 샌다

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        double l = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());

        double[] arr = new double[n];

        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx] = Double.parseDouble(st.nextToken());
            idx++;
        }

        Arrays.sort(arr);
        int cnt = 1;
        double now = arr[0];
        double left = now - 0.5;
        double right = l + left;

        for (int i = 1; i < arr.length; i++) {

            now = arr[i];

            if (now - 0.5 >= right) {
                left = now - 0.5;
                right = left + l;
            } else if (now - 0.5 < right && now + 0.5 > right) {
                left = right;
                right = left + l;
            } else {
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);

    }

}


