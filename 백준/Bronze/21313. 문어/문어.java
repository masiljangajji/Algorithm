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

        int N = sc.nextInt();

        // 문어는 여덟개의 팔
        // 1,2,3....8번

        // 각 문어는 양 옆의 서로 다른 두 문어와 손을 맞잡는다
        // 서로 같은 번호의 손
        // 한 문어와는 하나의 손만
        // 한 손으로 여러 문어의 손을 잡을 수 없음

        for (int i = 1; i < N; i++) {
            if (i % 2 == 0)
                System.out.print("2 ");
            else
                System.out.print("1 ");
        }

        if (N % 2 == 0)
            System.out.print("2");
        else
            System.out.println("3");


    }

}


