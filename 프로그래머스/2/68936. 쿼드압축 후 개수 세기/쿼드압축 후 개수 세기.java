import java.util.*;
import java.lang.*;

class Solution {
    
    int [] cnt = new int[2];
    int[] answer = new int[2];
    
    
    public int[] solution(int[][] arr) {
        
        // 압축하고자 하는 영역 S 
        
        // S 내부에 있는 모든 수가 같으면 하나로 압축 
        
        // 그렇지 않으면 S를 4개의 정사각형으로 쪼갬 
        
        int size = arr.length;
        
        dfs(0,size,0,size,size/2,arr);
        
        return answer;
    }
    
    void dfs(int startX,int endX,int startY,int endY,int half,int[][]arr){
                    
        int num = arr[startY][startX];
        boolean flag = false;
        
        for(int i=startY;i<endY;i++){
            for(int j=startX;j<endX;j++){
                if(num!=arr[i][j]){
                    flag=true;
                    break;
                }
            }
            
            if(flag){
                dfs(startX,endX-half,startY,endY-half,half/2,arr);
                dfs(startX+half,endX,startY,endY-half,half/2,arr);
                dfs(startX,endX-half,endY-half,endY,half/2,arr);
                dfs(startX+half,endX,endY-half,endY,half/2,arr);         
                return;
            }
        }        
        
        answer[num]++;
        
    }
    
}