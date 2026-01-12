class Solution {
    
    private static final boolean[]visited = new boolean[201];
    
    public int solution(int n, int[][] computers) {
        int cnt=0;
        
        for(int i=0;i<n;i++){
           if(!visited[i]){
               dfs(computers,i);
               cnt++;
           }
        }
        return cnt;
    }
    
    private void dfs(int [][]computers,int current){

        visited[current] = true;
        
        for(int next=0;next<computers[current].length;next++){
            
            if(next==current)
                continue;
            if(computers[current][next]==0)
                continue;
            if(visited[next])
                continue;
            
            dfs(computers,next);
        }
    }
    
    
    
}