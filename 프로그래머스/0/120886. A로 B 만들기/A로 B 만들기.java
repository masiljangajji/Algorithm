import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        int []count = new int[200];
        
        
        if(before.length()!=after.length())
            return 0;
        
        char ch;
        
        for(int i=0;i<before.length();i++){
            ch = before.charAt(i);
            count[ch-'0']++;
        }
        
        for(int i=0;i<after.length();i++){
            ch = after.charAt(i);
            
            if(count[ch-'0']==0)
                return 0;
            
            count[ch-'0']--;
        }
        
        return 1;
    }
}