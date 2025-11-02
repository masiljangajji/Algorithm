import java.util.*;
class Solution {
    public String solution(String[] participants, String[] completions) {
      
        // 10만, 20 -> 200만 
        // 동명이인이 있을 수 있다 
        
        Map<String,Integer> m = new HashMap<>();
        
        // O(N) -> 10만
        for(String participant : participants){
            m.putIfAbsent(participant,0);
            m.put(participant,m.get(participant)+1);
        }
        
        // O(N) -> 10만
        for(String completion : completions){
            
            if(!m.containsKey(completion))
                return completion;
            
            int current = m.get(completion)-1;
            if(current<0)
                return completion;
            if(current==0){
                m.remove(completion);
                continue;
            }
            
            m.put(completion,current);
        }
        
        Set<String> s = m.keySet();
        
        return s.iterator().next();
        
    }
}