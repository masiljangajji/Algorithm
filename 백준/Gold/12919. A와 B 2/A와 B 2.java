import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // A와 B로만 이루어진 영어 단어

        // S,T 주어졌을때 S를 T로 바꾸는 게임

        // 1. 문자열 뒤에 A를 추가
        // 2. 문자열 뒤에 B를 추가하고 문자열 뒤집기

        // S를 T로 만들 수 있는지 알아내자

        String s = sc.nextLine();
        String t = sc.nextLine();

        dfs(s, t);
        System.out.println(answer);

    }

    public static void dfs(String s, String t) {

        if (s.equals(t)) {
            answer = 1;
            return;
        }

        if (s.length() >= t.length()) {
            return;
        }


        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            StringBuilder stb = new StringBuilder(t);
            stb.deleteCharAt(0);
            stb.reverse();
            dfs(s, stb.toString());
        }

    }


}


