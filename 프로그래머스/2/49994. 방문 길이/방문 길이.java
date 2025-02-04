import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        // 0,0 에서 시작 
        // 맵은 -5~5 크기 
        
        Pair p = new Pair(0,0);
        
        boolean [][][]visit = new boolean[11][11][5];
        int cnt=0;
        int dir = 0;
        for(int i=0;i<dirs.length();i++){
            
            char ch = dirs.charAt(i);
            
            int ny=p.y;
            int nx=p.x;
            
            if(ch=='U'){ // 위로 한칸
                ny+=1;
                dir=2;
            }else if(ch=='D'){ // 아래로 
                ny-=1;
                dir=4;
            }else if(ch=='R'){ // 오른쪽 
                nx+=1;
                dir=1;
            }
            else if(ch== 'L'){ // 왼쪽 
                nx-=1;
                dir=3;
            }
                
            if(ny<-5|nx<-5|ny>5|nx>5){ // 맵 범위 밖
                continue;
            }

                
            
            if(visit[p.x+5][p.y+5][dir]){ // 방문이면 거리안재기 
                    p.y=ny;
                    p.x=nx;
                    continue;
            }
            

            // 방문안했으니까 방문처리하고 거리재기
        
            if(dir==1){
                visit[p.x+5][p.y+5][1]=true;    
                visit[nx+5][ny+5][3]=true;                    
            }
            else if(dir==2){
                visit[p.x+5][p.y+5][2]=true;    
                visit[nx+5][ny+5][4]=true;    
            }else if(dir==3){
                visit[p.x+5][p.y+5][3]=true;    
                visit[nx+5][ny+5][1]=true;    
            }else{
                visit[p.x+5][p.y+5][4]=true;    
                visit[nx+5][ny+5][2]=true;    
            }
        
            p.y=ny;
            p.x=nx;
            cnt++;
        }
        
        
        return cnt;
    }
}

class Pair{
    
    public int y;
    public int x;
    
    Pair(int x,int y){
        this.y=y;
        this.x=x;
    }
    
}