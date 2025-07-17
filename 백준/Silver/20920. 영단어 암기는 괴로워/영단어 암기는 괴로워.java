import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort((w1, w2) -> {
            int freq1 = map.get(w1);
            int freq2 = map.get(w2);

            if (freq1 != freq2) return Integer.compare(freq2, freq1); // 자주 등장
            if (w1.length() != w2.length()) return Integer.compare(w2.length(), w1.length()); // 긴 단어
            return w1.compareTo(w2); // 알파벳 순
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}