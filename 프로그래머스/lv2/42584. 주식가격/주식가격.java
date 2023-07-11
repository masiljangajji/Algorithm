import java.util.*;

class Solution {
    
    public static class Pair {

        int idx, value;

        Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

    }
    
    
    public int[] solution(int[] prices) {
       
         Stack<Pair> stk = new Stack<>();
        int[] ans = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {

            if (stk.empty()) {
                stk.push(new Pair(prices[i], i));
            } else {
                while (stk.peek().value > prices[i]) {
                    ans[stk.peek().idx] = i - stk.peek().idx;
                    stk.pop();
                    if(stk.empty())
                        break;
                }
                stk.push(new Pair(prices[i], i));
            }
        }
        
        while (!stk.empty()) {
            ans[stk.peek().idx] = prices.length - stk.peek().idx - 1;
            stk.pop();
        }
        
        
        return ans;
    }
}