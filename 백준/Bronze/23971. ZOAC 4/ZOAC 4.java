import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H, W, N, M;

        // 테이블이 행마다 W개씩 H행에 걸쳐 있다

        // 모든 참가자는 세로롤 N칸 or 가로로 M칸 비우고 앉아야 함
        // 최대 몇 명을 수용 할 수 있는지?

        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();

        // 가로 길이4, 가로로 M 만큼 비어있어야 함

        // x, x+M+1, x+2*M+1
        // y, y+N+1 , y+2*N+1

        // 1, 3

        // 1, 3 , 5

        int xCount = 0;
        int yCount = 0;
        int x = 1;
        int y = 1;
        while (x <= W) {
            xCount++;
            x += M + 1;
        }

        while (y <= H) {
            yCount++;
            y += N + 1;
        }

        System.out.println(xCount * yCount);

    }
}

