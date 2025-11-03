import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        
        // 트럭이 일차선 다리를 정해진 순으로 건넌다.
        
        // 트럭에 올라갈 수 있는 최대 트럭 수 존재, 견딜수 있는 무게 존재 
        
        int totalWeight = 0;
        int i=0;
        int cnt=0;
        
        Queue<Pair>q = new LinkedList<>();
        
        for(int time=1;;time++){
            
            if(!q.isEmpty()&&q.peek().time==time){
                Pair p = q.poll();
                if(p.idx==truckWeights.length-1)
                    return time;
                totalWeight-=truckWeights[p.idx];
                cnt--;
            }
            
            if(i<truckWeights.length&&cnt<bridgeLength&&totalWeight+truckWeights[i]<=weight){
                q.add(new Pair(i,time+bridgeLength));
                totalWeight+=truckWeights[i++];
                cnt++;
            }
            
        }
        
    }
}

class Pair{
    
    int idx;
    int time;
    
    public Pair(int idx,int time){
        this.idx=idx;
        this.time=time;
    }
    
}