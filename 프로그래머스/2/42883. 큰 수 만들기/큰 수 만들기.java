import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character>st = new Stack<>();
        int cnt=0;
        
        for(char ch : number.toCharArray()){
            
            if(st.isEmpty()){
                st.add(ch);
                continue;
            }
            
            while(!st.isEmpty()&&ch>st.peek()&&cnt<k){
                st.pop();
                cnt++;
            }
            st.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(cnt<k){
            st.pop();
            cnt++;
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        
        return sb.reverse().toString();
    }
}