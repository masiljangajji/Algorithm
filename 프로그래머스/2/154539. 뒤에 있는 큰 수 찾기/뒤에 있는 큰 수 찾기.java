import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        
        Arrays.fill(answer,-1);
        
        Stack<Integer>st = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
        
            while(!st.empty()&&arr[st.peek()]<arr[i]){
                answer[st.pop()] = arr[i];
            }
        
            st.push(i);
        }
    
        
        return answer;
    }
}