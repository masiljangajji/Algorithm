import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 에너지 드링크들을 합쳐서 하나의 에너지 드링크로 만들어 마신다.

        /**
         *
         * 임의의 서로 다른 두 에너지 드링크를 고른다.
         * 한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다. 단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다.
         * 다 붓고 남은 빈 에너지 드링크는 버린다.
         * 1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.
         *
         */

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] arr = new double[n];
        int i = 0;

        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(arr);

        double sum = arr[arr.length - 1];

        for (i = arr.length - 2; i >= 0; i--) {
            sum += arr[i] / 2;
        }

        if (sum == Math.floor(sum)) {
            System.out.printf("%.0f", sum);
        } else {
            System.out.println(sum);
        }

    }

}


