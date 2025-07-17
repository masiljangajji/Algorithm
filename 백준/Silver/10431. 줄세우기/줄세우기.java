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


        // 아이들에게 키 순서대로 번호를 부여 함
        // 키가 가장 작은 아이가 1번...큰 아이가 20번

        // 같은 키를 같는 경우는 없다

        // 아무나 한 명 뽑아, 줄의 맨 앞에 세운다.
        //학생이 한 명씩 줄의 맨뒤에 섬

        // 자기 앞에 키 큰 학생이 없다면 그 자리에 섬
        // 자기 앞에 키 큰 학생이 있으면 그 중 가장 앞에있는 학생 A 앞에 선다
        // 이 때,  A부터 그 뒤의 모든 학생들은 공간을 만들기 위해 한발씩 뒤로 물러섬

        // 학생들이 총 몇 번 뒤로 물러나게 될 까? = 학생 맨뒤에 새웠을때 그 학생보다 큰 학생의 수 총 합

        int p = Integer.parseInt(br.readLine());


        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int answer = 0;

            int t = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            int cnt = 0;

            for (int r = 0; r < list.size(); r++) {
                for (int q = 0; q < r; q++) {
                    if (list.get(r) < list.get(q)) {
                        cnt++;
                    }
                }
            }

            System.out.println(t + " " + cnt);

        }

    }
}
