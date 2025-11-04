import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 학생 번호는 오름차 순 +-1에만 빌려줄 수 있다 
        
        int idx=0;
        int answer = n-lost.length;
        
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    lost[i]=reserve[j]=0;
                    answer++;
                    break;
                }
            }
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int l:lost){
            for(int i=0;i<reserve.length;i++){
        
                int r = reserve[i];
                
                if(l==0||r==0)
                    continue;
                
                if(r-1==l||r+1==l){
                    reserve[i]=0;
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}