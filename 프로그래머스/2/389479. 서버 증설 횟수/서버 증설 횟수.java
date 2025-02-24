import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 이용자 m 명이 늘어날 때마다 서버 1대가 추가로 필요
        
        // m명 미만이면 서버 증설이 필요하지 않아요~
        
        // 한번 증설한 서버는 K시간동안 운영하고 반납
        
        // k = 5 일 때 10시에 증설한 서버는 10 ~ 15시에만 운영됨 
        
        // 모든 게임 이용자가 게임을 하기 위해 서버를 몇 번 증설해야 하니
        
        List<Integer>serverList = new LinkedList<>();
        int cnt=0;
        int current;
        
        for(int i=0;i<players.length;i++){
            
            Iterator<Integer>iterator = serverList.iterator();
            
            while(iterator.hasNext()){
                int time = iterator.next();
                if(time<=i){
                    iterator.remove();
                }
            }
            
            int numberOfServer = players[i]/m; // 필요한 서버 수 
            int serverSize = serverList.size(); // 보유한 서버 수 
            
            
            if(serverSize<numberOfServer){ // 서버가 감당안되면 
                
                numberOfServer-=serverSize; // 기존 서버 뺴주고 
                
                for(int p=0;p<numberOfServer;p++){
                    serverList.add(i+k); // 리스트에 필요한 서버 개수만큼 유지 기간 넣기 
                }
                cnt+=numberOfServer; // 증설한 서버 갯수 
            }
            
            
        }
        
        return cnt;
    }
}