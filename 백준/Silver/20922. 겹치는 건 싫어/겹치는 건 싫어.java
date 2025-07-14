import javax.swing.*;
import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // 수열에서 같은 원소가 여러 개 들어 있는 수열을 싫어한다
        // 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이

        // 10만 이하의 양의 정수, 길이가 N 인 수열 (20만개 까지)
        // K개 이하로 포함한 수열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left, right;
        left = right = 0;
        Map<Integer, Integer> m = new HashMap<>();

        int length = 0;
        int max = 0;
        while (true) {

            if (right == n) {
                break;
            }

            int num = arr[right];
            int numberCount = m.getOrDefault(num, 0);

            if (numberCount < k) {
                m.put(num, numberCount + 1);
                right++;
                length++;
            } else {
                m.put(arr[left], m.get(arr[left]) - 1); // 빈도 초기화
                left++;
                length--;
            }

            max = Math.max(max, length);
        }

        System.out.println(max);

    }


}




