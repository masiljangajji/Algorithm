import java.util.*;
import java.lang.*;

class Solution {
    
    public int[] solution(int n) {
        
        
        int cnt = 1;
        int number = n;
        
    
        int [][] arr= new int[n][n];
                
        int col = 0;
        int row = 0;
        int count =0;
        
        while(true){
            
            for(int i=0;i<n;i++){
                arr[col++][row] = cnt++;
            }
                        
            row++;
            col--;
            n--;
            
            if(n==0){
                break;
            }
            
            for(int i=0;i<n;i++){
                arr[col][row++] = cnt++;
            }

            row--;
            n--;
            
            if(n==0){
                break;
            }
            
            for(int i=0;i<n;i++){
                arr[--col][--row] = cnt++;
            }   
            col++;
            n--;
            
            if(n==0){
                break;
            }
        
        }
        
        int []answer = new int[cnt-1];
        
        int idx = 0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    answer[idx++] = arr[i][j];
                }else
                    break;
            }
        }
        
        return answer;
    }
    
    public void prt(int[][]arr){
        
        System.out.println("Start");

        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.printf("%3d ",arr[i][j]);
            }
            System.out.println();
        }
    }
    
}