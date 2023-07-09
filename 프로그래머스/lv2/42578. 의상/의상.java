import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
   
        Map<String,Integer>m= new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            m.put(clothes[i][1],m.get(clothes[i][1])==null?1:m.get(clothes[i][1])+1);
        }
        
        List<Integer>v = new ArrayList<>(m.values());
        
         int answer = 1;
        
        for(Integer a:v){
            answer*=(a+1);
            System.out.println(a);
        }
        
        
        return answer-1;
    }
}