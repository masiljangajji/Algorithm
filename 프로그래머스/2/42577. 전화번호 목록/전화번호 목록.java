import java.util.*;
class Solution {
    public boolean solution(String[] phoneBook) {
        boolean answer = true;
        
        // 12 145 1245
        // 12 1245 145
        
        Arrays.sort(phoneBook);
        
        for(int i=0;i<phoneBook.length-1;i++){
            if(phoneBook[i+1].startsWith(phoneBook[i]))
                return false;
        }
        
        return true;
    }
}