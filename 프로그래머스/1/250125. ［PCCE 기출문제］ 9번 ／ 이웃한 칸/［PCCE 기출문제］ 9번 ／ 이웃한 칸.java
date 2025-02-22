import java.util.*;
import java.lang.*;


class Solution {
    
    int []dy ={0,0,1,-1};
    int []dx ={1,-1,0,0};
    
    public int solution(String[][] board, int h, int w) {
        
        String str = board[h][w];
                
        int cnt=0;
        int size = board.length;
        
        
        for(int i=0;i<4;i++){
            int ny = h+dy[i];
            int nx = w+dx[i];
            
            if(ny<0||nx<0||ny>=size||nx>=size)
                continue;
            
            if(str.equals(board[ny][nx]))
                cnt++;
        }
        
        
        
        return cnt;
    }
}