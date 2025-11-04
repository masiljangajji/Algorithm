import java.util.*;
class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 가장 많이 겹치는 지점에 카메라를 설치
        // 그 지점을 어떻게 찾음?
        Arrays.sort(routes,(v1,v2)-> v1[1]-v2[1]);
            
        int last=Integer.MIN_VALUE;
        
        for(int []r:routes){
        
            if(last>=r[0]&&last<=r[1])
                continue;
            
            last = r[1];
            answer++;
        }
        
        
        return answer;
    }
}