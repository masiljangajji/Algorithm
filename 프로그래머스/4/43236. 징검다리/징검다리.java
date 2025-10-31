import java.util.*;
class Solution {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        rocks = Arrays.copyOf(rocks,rocks.length+1);
        rocks[rocks.length-1] = distance;
        Arrays.sort(rocks);
        
        // 이진탐색 
        
        // 시작 = 1
        // 끝 = 10억 
        
        // 바위 n개를 지워서, 거리 d에 대해서 모든 지점 사이의 거리가 d 이상 되는 것 중 가장 큰 거 
        
        int start= 1;
        int end = distance+1;
        
//         while(start<end){
            
//             int 
            
//         }
        
        while(end-start>1){
            int d = (start+end)/2;
            
            // true 
            if(isValid(rocks,n,d)){
                start = d;
            }else{
                end = d;
            }
        }
        
        return start;
    }
    
    private boolean isValid(int rocks[],int n,int length){
        
        int cnt=0;
        int current =0;
        
        for(int rock : rocks){
            
            if(rock - current<length){
                cnt++;
                continue;
            }
            current = rock;
        }
        return cnt<=n;
    }
    
    
}