import java.util.*;
class Solution {
    public int[] solution(long n) {
        String reversed = new StringBuilder(String.valueOf(n)).reverse().toString();
        
        return reversed.chars()  // String → IntStream
                       .map(c -> c - '0')  // 문자 → 숫자
                       .toArray();
    }
}