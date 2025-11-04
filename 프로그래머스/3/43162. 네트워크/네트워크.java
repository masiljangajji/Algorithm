class Solution {
    
    private boolean[]visited= new boolean[201];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 입력 200개 
        for(int i=0;i<n;i++){
            answer +=dfs(i,computers);
        }
        return answer;
    }
    
    private int dfs(int start,int [][]computers){
        // 1번 컴퓨터에서 갈 수 있는 모든 경로를 체크 하겠다 
        
        if(visited[start])
            return 0;
        visited[start] = true;
        
        for(int j=0;j<computers[start].length;j++){
            if(start==j)
                continue;                
            
            if(computers[start][j]==0)
                continue;
            
            dfs(j,computers);
        }
        return 1;
    }
    
}