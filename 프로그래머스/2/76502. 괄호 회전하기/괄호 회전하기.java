import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            String str = s.substring(i,s.length())+s.substring(0,i);
            
            if(isValid(str))
                answer++;
            // System.out.println(str+" "+answer);
        }
        
        return answer;
    }
    
    private boolean isValid(String str){
    
        Stack<Character> st = new Stack<>();
        
        for(char ch : str.toCharArray()){
                        
            if(st.isEmpty()){
                st.add(ch);
                continue;       
            }
            
            char peek = st.peek();
            
            switch(peek){
                case '[':
                    if(ch==']'){
                        st.pop();
                        break;
                    }   
                case '(':
                    if(ch==')'){
                        st.pop();
                        break;
                    }
                case '{':
                    if(ch=='}'){
                        st.pop();
                        break;
                    }
                default:
                    st.add(ch);
            }
        }
        
        return st.isEmpty();
    }
    
    
}