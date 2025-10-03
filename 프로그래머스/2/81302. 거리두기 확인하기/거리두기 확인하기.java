import java.util.*;

class Solution {
    
    private static int dy[]={-1,0,0,1};
    private static int dx[]={0,-1,1,0};
    
    public int[] solution(String[][] places) {
        
        // 대기실은 5개, 5x5 크기 
        // 맨허튼 거리가 2초과 
        // 파티션이 있는 경우 허용 
        
        // 1. 모든 P 의 위치를 찾아서 저장
        // 2. O(N^2) 완탐, 거리 측정
        // 3. 거리 불충족 하는 경우, 파티션 확인
        // 4. 시작 위치에서 도착 위치까지 파티션에 막히지 않고 가는게 불가능하면 허용 
    
        int[] answer = new int[5];
        
        for(int i=0;i<answer.length;i++){
            
            String[]place = places[i];
            char[][]room = new char[place.length][];
            
            for(int j=0;j<place.length;j++){
                room[j] = place[j].toCharArray();
            }
            
            answer[i] = isDistanced(room)?1:0;
        }
        
        
        return answer;
    }
    
    private boolean isDistanced(char [][]room){
        
        
        for(int i=0;i<room.length;i++){
            for(int j=0;j<room[i].length;j++){
                if(room[i][j]!='P')
                    continue;
                if(!isDistanced(room,i,j))
                    return false;
            }
        }
        return true;
    }
    
    private boolean isDistanced(char [][]room,int y,int x){
        
        for(int d=0;d<4;d++){
            
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if(ny<0||nx<0||ny>=room.length||nx>=room.length)
                continue;
            
            if(room[ny][nx]=='P')
                return false;  
            
            if(room[ny][nx]=='O'){
                if(!checkNext(room,ny,nx,3-d)){
                    return false;
                }
            }
        }  
        return true;
    }
    
    private boolean checkNext(char[][]room,int y,int x,int dir){
        for(int d=0;d<4;d++){
            
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if(d==dir)
                continue;
            
            if(ny<0||nx<0||ny>=room.length||nx>=room.length)
                continue;
            
            if(room[ny][nx]=='P')
                return false;  
        }  
        return true;
    }
       
}