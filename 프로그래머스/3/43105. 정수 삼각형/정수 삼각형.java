import java.util.*;
class Solution {
    
    private int [][]dp= new int[501][501];
    private int MAX = 0;
    private int n;
    
    public int solution(int[][] triangle) {
        
        n=triangle.length;
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,triangle);
    }
    
    private int solve(int y,int x,int[][]triangle){
        
        if(y==n-1)
            return triangle[y][x];
        
        if(dp[y][x]!=-1)
            return dp[y][x];
        
        int left = solve(y+1,x,triangle);
        int right = solve(y+1,x+1,triangle);
        return dp[y][x] = triangle[y][x] + Math.max(left,right);
    }
    
}