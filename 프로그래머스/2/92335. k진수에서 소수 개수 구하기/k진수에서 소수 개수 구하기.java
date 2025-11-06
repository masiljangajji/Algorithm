import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
    
        String[]tokens = Long.toString(n,k).split("0+");
        
        for(String s:tokens){
            if(isPrime(Long.parseLong(s)))
                answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long v){
        
        if(v<=1)
            return false;
        
        for(long i=2;i*i<=v;i++){
            if(v%i==0)
                return false;
        }
        return true;
    }
    
}