import java.util.*;
import java.lang.*;

class Solution {
    
    boolean check(int gy,int gx,int y,int x){
        if(gy>=y&&gx>=x){
            return true;
        }else if(gy>=x&&gx>=y){
            return true;
        }
        return false;
    }
    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 길이 긴쪽을 반 접음
        // 접기전 길이 홀수면 소수점 버림
        // 접힌 지폐를 지갑 넣을 수 있음 그만 
        
        int goalY=wallet[0];
        int goalX=wallet[1];
        
        int y=bill[0];
        int x=bill[1];
        int cnt=0;
        
        while(true){
            
            if(check(wallet[0],wallet[1],y,x)){
                return cnt;
            }
            
            if(y>x){
                y/=2;
            }else{
                x/=2;   
            }
            
            cnt++;
            
        }

    }
}