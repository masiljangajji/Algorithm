import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] chars = s.toCharArray();
        
        String []str = new String[s.length()];
        
        for(int i=0;i<str.length;i++){
            str[i] = String.valueOf(chars[i]);
        }
        
        Arrays.sort(str,(v1,v2)->v2.compareTo(v1));
        
        for(int i=0;i<str.length;i++){
            answer+=str[i];
        }
        
        return answer;
    }
}