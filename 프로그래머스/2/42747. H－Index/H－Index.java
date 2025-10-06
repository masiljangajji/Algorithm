import java.util.*;
class Solution {
    public int solution(int[] citations) {

        // n편 중, h 번 이상 인용된 논문이 H 편 이상 
        // 나머지 논문이 H 번 이하로 인용됐을때 최대 값 
        
        Arrays.sort(citations);
        
        int answer=0;
        
        for(int i=0;i<citations[citations.length-1];i++){
            
            // idx 부터 i번 이상 인용된 논문
            int idx = getIndex(citations,i);
            if(i<=citations.length-idx)
                answer=i;
            
        }
        
        return answer;
    }
    
    private int getIndex(int[]citations,int h){
        
        int current = 0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=h)
                return current;
            current++;
        }
        return current;
    }
}