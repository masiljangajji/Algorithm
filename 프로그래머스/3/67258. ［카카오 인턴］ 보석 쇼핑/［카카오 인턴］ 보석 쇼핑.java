import java.util.*;
class Solution {
    
    private Map<String,Integer>m= new HashMap<>();
    
    public int[] solution(String[] gems) {
        int[] answer = {0,Integer.MAX_VALUE};
            
        Set<String> set= new HashSet<>();
        for(String s:gems){
            set.add(s);
        }
        
        int SIZE = set.size();
        return getShortestPath(SIZE,gems);
    }
    
    private int[] getShortestPath(int SIZE,String[]gems){
        
        int left = 0;
        int right = -1;
        int []path = {0,Integer.MAX_VALUE};
        
        // 4 < 5
        while(right+1<gems.length){

            right++;
            String gem = gems[right];
            m.putIfAbsent(gem,0);
            m.put(gem,m.get(gem)+1);
            
            while(m.keySet().size()==SIZE){
                
                if(right-left<path[1]-path[0]){
                    path[0]=left+1;
                    path[1]=right+1;
                }
                String L = gems[left];
                
                m.put(L,m.get(L)-1);
                if(m.get(L)==0){
                    m.remove(L);
                }
                left++;
            }
        }
        
        return path;
    }
    
}