import java.util.*;
class Solution {
    
    int []dx ={-1,1,0,0};
    int []dy ={0,0,-1,1};
    boolean[][]visited = new boolean[101][101];
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,0,1));
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            
            if(p.y==maps.length-1&&p.x==maps[0].length-1)
                return p.cnt;
            
            for(int i=0;i<4;i++){
                
                int ny = p.y+dy[i];
                int nx = p.x+dx[i];
                
                // 행렬 범위를 벗어나면 
                if(ny<0||nx<0||ny>=maps.length||nx>=maps[0].length)
                    continue;
                
                // 좌표가 이미 방문 했으면 
                if(visited[ny][nx])
                    continue;

                // 벽으로 막혀있으면 
                if(maps[ny][nx]==0)
                    continue;      
                
                visited[ny][nx] = true;
                q.add(new Pair(ny,nx,p.cnt+1));
            }
        }
        
        return -1;
    }
}

class Pair{
    
    int y;
    int x;
    int cnt=0;
    Pair(int y,int x,int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
    
}