import java.util.*;
class Solution {
    public String solution(String myString) {
        String answer = "";
        
        Set<Character> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<myString.length();i++){
            char ch = myString.charAt(i);
            
            if(set.contains(ch))
                continue;
            
            sb.append(ch);
            set.add(ch);
        }
        
        
        return sb.toString();
    }
}