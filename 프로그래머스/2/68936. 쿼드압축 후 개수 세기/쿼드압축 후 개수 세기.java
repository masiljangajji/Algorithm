import java.util.*;

class Solution {
    
    private static int zero=0;
    private static int one=0;
    
    public int[] solution(int[][] arr) {
        
        dfs(arr,0,0,arr.length);
        return new int[]{zero,one};
        
    }
    
    public void dfs(int[][]arr,int y,int x,int size){
        
        int num = arr[y][x];
        
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(num!=arr[i][j]){
                    dfs(arr,y,x,size/2);
                    dfs(arr,y,x+size/2,size/2);
                    dfs(arr,y+size/2,x,size/2);
                    dfs(arr,y+size/2,x+size/2,size/2);
                    return;
                }        
            }
        }
        
        if(num==1)
            one+=1;
        else
            zero+=1;
        
    }

    
}