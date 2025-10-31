import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0;
        long end = 1000000000L*1000000000L;
        
        while(start<end){
            
            long mid = (start+end)/2;
            
            if(isValid(mid,n,times)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        
        return start;
    }
    
    private boolean isValid(long t,int n,int[]times){
        long c = 0;
        
        for(int time:times){
            c+=t/time;
        }
        return c>=n;
    }
    
}
