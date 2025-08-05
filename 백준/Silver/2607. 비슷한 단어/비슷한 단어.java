import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    public static int[] arr = new int[27];
    public static int[] arr2 = new int[27];

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        String str = br.readLine();


        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }

        for (int i = 1; i < n; i++) {

            String comparedStr = br.readLine();

            if (Math.abs(str.length() - comparedStr.length()) >= 2) {
                continue;
            }

            for (int j = 0; j < comparedStr.length(); j++) {
                arr2[comparedStr.charAt(j) - 'A']++;
            }


            cnt += isSimilar();
//            System.out.println(cnt);
            Arrays.fill(arr2, 0);


        }

         System.out.println(cnt);

    }

    public static int isSimilar() {

        int diffAlphabetCount = 0;

        for (int i = 0; i < arr.length; i++) {

            diffAlphabetCount += Math.abs(arr[i] - arr2[i]); // 서로 차이가 있으면 1까지는 괜찮음 바꾸면 되니까

            if (diffAlphabetCount > 2) {
                return 0;
            }
        }

        return 1;

    }

    // AAABC

}


