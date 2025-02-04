import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] s, int K) {

        int cnt=0;
        
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        
        for(int n:s){
            pq.offer(n);
        }
        
        while(pq.size()>=2&&pq.peek()<K){
            int min = pq.poll();
            int next = pq.poll();
            
            pq.offer(min+next*2); // mix 더하기 
            
            cnt++;
        }
        
        
        return pq.peek()>=K?cnt:-1;
    }
}