import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            // 스택이 비어있는 경우 
            if(st.isEmpty()){
                st.add(ch);
                continue;
            }
            
            char peek = st.peek();
                
            if(peek=='('&&ch==')'){
                st.pop();
                continue;
            }
            
            st.add(ch);
        }
        
        return st.isEmpty();
    }
}