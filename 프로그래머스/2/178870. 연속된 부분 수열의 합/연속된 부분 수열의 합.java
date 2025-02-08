import java.util.*;
import java.lang.*;


class Solution {
    public int[] solution(int[] sequence, int k) {
        
        
        
        int MIN = 123456789;
        int []answer= new int[2];
        int left =0;
        int right = 0;
        long sum = sequence[0];
        
        
        while(right<sequence.length){
            
            if(sum==k){ 
                if(right-left<MIN){
                    MIN = right - left;
                    answer[0]= left;
                    answer[1] = right;
                }
            }
            
            if(sum>=k){
                sum-=sequence[left];
                left++;
            }else if(sum<k){
                right++;
                if(right<sequence.length)
                    sum+=sequence[right];
            }
        }
        
        return answer;
 
    }
}