import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    
    public static int[][] visit = new int[104][104];
    public static int dy[]={0,0,-1,1};
    public static int dx[]={-1,1,0,0};

    public static int n;
    public static int m;

    public static class Pair {

        int y,x;
        Pair(int y,int x){
            this.y=y;
            this.x=x;
        }

    }
    
    public static int dfs(int y,int x,String [] maps){

        for(int i=0;i<n;i++){
            Arrays.fill(visit[i],0);
        }

        Queue<Pair>q = new LinkedList<>();

        q.add(new Pair(y,x));

        int cnt=0;
        int hereY,hereX;
        hereY=hereX=-1;

        while(!q.isEmpty()){
            Pair here= q.poll();
            int yidx=here.y;
            int xidx=here.x;

            for(int i=0;i<4;i++) {
                int ny = yidx + dy[i];
                int nx = xidx + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (visit[ny][nx] > 0)
                    continue;
                if (maps[ny].charAt(nx) == 'X')
                    continue;

                if (maps[ny].charAt(nx) == 'L') {
                    cnt += visit[yidx][xidx] + 1;
                    hereY = ny;
                    hereX = nx;
                    q.clear();
                    break;
                } else {
                    q.add(new Pair(ny, nx));
                    visit[ny][nx] = visit[yidx][xidx] + 1;
                }
            }
        }

        if(hereX==-1)
            return -1;

        for(int i=0;i<n;i++){
            Arrays.fill(visit[i],0);
        }

        q.add(new Pair(hereY,hereX));

        while(!q.isEmpty()){
            Pair here= q.poll();
            int yidx=here.y;
            int xidx=here.x;

            for(int i=0;i<4;i++) {
                int ny = yidx + dy[i];
                int nx = xidx + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (visit[ny][nx] > 0)
                    continue;
                if (maps[ny].charAt(nx) == 'X')
                    continue;

                if (maps[ny].charAt(nx) == 'E') {
                    cnt += visit[yidx][xidx] + 1;
                    return cnt;
                } else {
                    q.add(new Pair(ny, nx));
                    visit[ny][nx] = visit[yidx][xidx] + 1;
                }
            }

        }

        return -1;
    }
    
    public int solution(String[] maps) {
        
        n=maps.length;
        m=maps[0].length();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j)=='S') {
                    return dfs(i,j,maps);
                }
            }
        }
        
        return 0;
    }
}