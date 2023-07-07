import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.Arrays.sort;

class Solution {
    
    static int []dy= {0,0,-1,1};
    static int []dx= {-1,1,0,0};

    static int [][]visit = new int[104][104];
    public static class Pair{

        int y,x;

        Pair(int y,int x){
            this.y=y;
            this.x=x;
        }
    }

    public static int dfs(int[][]maps){
    
        visit[0][0]=1;
        Queue<Pair>q= new LinkedList<>();

        q.add(new Pair(0,0));

        while(!q.isEmpty()){

            int y=q.peek().y;
            int x=q.peek().x;

            q.poll();

            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];

                if(ny<0||nx<0||ny>=maps.length||nx>=maps[0].length)
                    continue;
                if(visit[ny][nx]>0)
                    continue;
                if(maps[ny][nx]==0)
                    continue;
                
                visit[ny][nx]=visit[y][x]+1;
                
                if(ny==maps.length-1&&nx==maps[0].length-1)
                    return visit[ny][nx];
                q.add(new Pair(ny,nx));
            }


        }
        
        return -1;

    }
    
    public int solution(int[][] maps) {
      
        return dfs(maps);
    }
}