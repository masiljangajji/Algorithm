import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
      
        
        Map<String,Integer> m = new HashMap<>();
        Map<String,Integer>m2 = new HashMap<>();

        for(int i=0;i<participant.length;i++){
            m.put(participant[i],m.get(participant[i])==null?1:m.get(participant[i])+1);
        }

        for(int i=0;i<completion.length;i++){
            m2.put(completion[i],m2.get(completion[i])==null?1:m2.get(completion[i])+1);
        }
        
        for(int i=0;i<participant.length;i++){
            
            if(m2.get(participant[i])==null)
                return participant[i];
            else if(m.get(participant[i])>m2.get(participant[i]))
                return participant[i];    
        }
        
        return "";
        
    }
}