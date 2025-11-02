import java.util.*;

class Solution {
    
    private int[][]dp = new int[101][101];
    private boolean[][]waters = new boolean[101][101];
    
    public int solution(int m, int n, int[][] puddles) {
        
        for(int []pud:puddles){
            waters[pud[1]][pud[0]]=true;
        }
        
        for(int i=1;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }        
        
        
        return solve(1,1,m,n);
    }
    
    private int solve(int y,int x,int m,int n){
        
        // 오른쪽, 아래쪽으로만 이동 
        if(y>n||x>m)
            return 0;
        
        if(waters[y][x]){
            return 0;
        }
        
        if(y==n&&x==m)
            return 1;
        
        if(dp[y][x]!=-1)
            return dp[y][x];
    
        int right = solve(y,x+1,m,n)%1000000007;
        int down = solve(y+1,x,m,n)%1000000007;
        
        return dp[y][x] = (right+down)%1000000007;
    }
    
}