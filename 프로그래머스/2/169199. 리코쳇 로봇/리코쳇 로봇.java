import java.util.*;
import java.lang.*;

class Solution {
    
    int []dy = {0,0,-1,1};
    int []dx = {-1,1,0,0};
    
    int [][]visit = new int [104][104];
    
    public int solution(String[] board) {
        int answer = 0;
        
        // . = 빈 공간
        // R = 처음 로봇 위치
        // D = 장애물 위치
        
        // 중요한 부분은 미끄러져 움직인다는 것 
        
        for(int i=0;i<100;i++){
            Arrays.fill(visit[i],-1);
        }
        Pair start = null;
        
        for(int i=0;i<board.length;i++){
            int idx = board[i].indexOf('R');
            if(idx>=0){
                start= new Pair(i,idx);
                visit[i][idx]=0;
                break;
            }        
        }
          
        
        Queue<Pair>q= new LinkedList<>();
        
        q.add(start);
        int cnt=0;
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            cnt++;
            
            // System.out.printf("%d %d\n",p.y,p.x);
            
            for(int i=0;i<4;i++){
                                
                Pair now = go(board,p.y,p.x,i,board.length,board[0].length());
                
                if(board[now.y].charAt(now.x)=='G'){
                    return visit[p.y][p.x]+1;
                }
                
                if(visit[now.y][now.x]>=0)
                    continue;
                
                q.add(now);
                visit[now.y][now.x] = visit[p.y][p.x]+1;
            }
        }
        
        return -1;
    }
    
    Pair go(String []board,int y,int x,int cnt,int sizeY,int sizeX){
        
        int ny=y;
        int nx=x;
        
        int currentX=x;
        int currentY=y;
        
        while(true){
            
            ny+=dy[cnt];
            nx+=dx[cnt];
            
            if(ny<0||nx<0||ny>=sizeY||nx>=sizeX){
                return new Pair(currentY,currentX);
            }
            
            if(board[ny].charAt(nx)=='D'){
                return new Pair(currentY,currentX);
            }
            
            currentX= nx;
            currentY= ny;
        }
            
        
    }
    
}

class Pair{
    
    int x;
    int y;
    
    public Pair(int y,int x){
        this.x=x;
        this.y=y;
    }
    
}