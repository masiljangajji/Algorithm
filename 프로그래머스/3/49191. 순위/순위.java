import java.util.*;
class Solution {
    
    boolean [][]arr;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        arr= new boolean[n+1][n+1];
        
        for(int [] result : results){
            // 이기면 T 
            arr[result[0]][result[1]] = true;
        }
        
        for(int i=1;i<=n;i++){
            if(countWin(i,new boolean[n+1])+countLose(i,new boolean[n+1])+1==n){
                answer++;
            }
        }
        
        return answer;
    }
    
    private int countWin(int n,boolean []visited){
        
        int count=0;
        
        for(int i=1;i<arr[n].length;i++){
            if(!arr[n][i]||visited[i])
                continue;
            
            visited[i] = true;
            count+=countWin(i,visited)+1;
        }
        return count;
    }
    
    private int countLose(int n,boolean[]visited){
        int count=0;
        
        for(int i=1;i<arr.length;i++){
            if(!arr[i][n]||visited[i])
                continue;
            visited[i]=true;
            count+=countLose(i,visited)+1;
        }
        return count;
    }
    
}