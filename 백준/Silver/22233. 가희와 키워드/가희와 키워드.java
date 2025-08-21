import java.beans.Introspector;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {

        // 메모장 키워드 다른거 N개
        // 새로운 글 작성시 최대 10개의 키워드 작성

        // 메모장 - 글  중복된 키워드는 지워지게 됨


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        StringBuilder stb = new StringBuilder();

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                set.remove(st.nextToken());
            }
            stb.append(set.size()).append("\n");
        }

        System.out.println(stb);
    }
}

