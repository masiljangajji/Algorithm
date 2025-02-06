import java.util.*;
import java.lang.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        if(x==y)
            return 0;
        
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Integer>visit = new HashMap<>();
        
        q.add(x);
        visit.put(x,0);
        
        while(!q.isEmpty()){
            
            int current = q.poll();
            int count = visit.get(current);
            
            int [] nextNumbers = {current+n,current*2,current*3};
            
            for(int next : nextNumbers){
                
                if(next>y)
                    continue;
                if(next==y)
                    return count+1;
                
                if(!visit.containsKey(next)){
                    visit.put(next,count+1);
                    q.add(next);
                }
                
            }
            
        }
        
        return -1;
    }
    
}


