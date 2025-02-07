import java.lang.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char num : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder result = new StringBuilder();
        for (char num : stack) {
            result.append(num);
        }
        
        return result.toString();
    }
}