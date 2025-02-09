import java.util.*;
import java.lang.*;

class Solution {

    boolean [][] visit = new boolean[104][104];
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    
    public int[] solution(String[] maps) {
        
        List<Integer>list = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                
                char ch = maps[i].charAt(j);
                
                if(ch!='X'&&visit[i][j]==false){
                    int cnt = dfs(i,j,maps)+ch-'0';
                    list.add(cnt);
                }
            }
        }
        
        if(list.isEmpty()){
            return new int[]{-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    int dfs(int y,int x,String []maps){
        
        int cnt=0;
        visit[y][x]=true;
        
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx=  x+dx[i];
            
            if(ny<0||nx<0||nx>=maps[0].length()||ny>=maps.length)
                continue;
            if(maps[ny].charAt(nx)=='X')
                continue;
            if(visit[ny][nx])
                continue;
            
            cnt+= maps[ny].charAt(nx)-'0';
            cnt+=dfs(ny,nx,maps);
        }
        
        return cnt;
        
    }
    
}