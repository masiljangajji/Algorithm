import java.util.*;
import java.lang.*;

class Solution {
    int solution(int[][] arr) {
        int answer = 0;

        // N행 4열로 이루어짐 
        
        // 모든 칸에는 점수 , 1행부터 땅을 밟으며 내려옴 
        // 각 행의 4칸중 한 칸만 밟음 
        // 같은 열을 계속해서 밟을 순 없음 
        
        // 각 행마다 하나의 열을 선택 , 같은 열을 중복 선택은 불가능 
        
        // 얻을 수 있는 점수의 최대값이 필요
        
        // 완탐
        // DP
        // 그리디 
 
         // 3,4 
   
        
        int [][] visit = new int[100001][4];
        
        for(int i=0;i<arr[0].length;i++){
            visit[0][i] = arr[0][i];
        }
        
        
        for(int i=0;i<arr.length-1;i++){
            
            for(int j=0;j<4;j++){ // x좌표 
                
                for(int p=0;p<4;p++){ // 이전좌표
                    if(j==p)
                        continue;
                    
                    visit[i+1][j] =  Math.max(visit[i+1][j],visit[i][p]+arr[i+1][j]);
                }
            }
        }
        
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer,visit[arr.length-1][i]);
        }

        return answer;
    }
}