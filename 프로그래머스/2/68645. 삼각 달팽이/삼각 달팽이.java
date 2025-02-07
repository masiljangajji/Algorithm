import java.util.*;
import java.lang.*;

class Solution {
    
    public int[] solution(int n) {
        
        
        int size=n;
        
        int [][] arr = new int[n][n];
        
        int cnt=1;
        
        int y=0,x=0;
        int dir=1;
        
        while(n>0){
            
            if(dir==1){
                for(int i=0;i<n;i++){
                    arr[x][y++] = cnt++;
                }            

                y--;
                x++;
                n--;  
                dir++;
                continue;
            }
            
            if(dir ==2){
                for(int i=0;i<n;i++){
                    arr[x++][y]=cnt++;
                }

                x--;
                n--;                
                dir++;
                continue;
            }
            
            
            for(int i=0;i<n;i++){
                arr[--x][--y]=cnt++;
            }
        
            y++;
            n--;
            dir=1;
            
        }
        
        int [] answer= new int[cnt-1];        
        int cnt2=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<=i;j++){
                answer[cnt2++]= arr[j][i];
            }
            System.out.println();
        }
        
        
        return answer;
    }
}