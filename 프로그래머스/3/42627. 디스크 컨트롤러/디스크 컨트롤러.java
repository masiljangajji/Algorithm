import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs,(v1,v2)->{
            return v1[0]-v2[0];
        });
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (v1,v2)->{
            if(v1.duration==v2.duration){
                if(v1.start==v2.start){
                    return v1.idx-v2.idx;
                }
                return v1.start-v2.start;
            }
            return v1.duration-v2.duration;
            }
        );
            
        
        int time=0;
        int answer=0;
        int idx=0;
        int done=0;
        
        while(done<jobs.length){
            
            while(idx<jobs.length&&time>=jobs[idx][0]){
                pq.add(new Pair(idx,jobs[idx][0],jobs[idx][1]));
                idx++;
            }
           
            if(!pq.isEmpty()){
                Pair p = pq.poll();
                time+=p.duration;
                answer+=(time-p.start);
                done++;
            }else{
                time = Math.max(time,jobs[idx][0]);
            }
        }
        
        return answer/jobs.length;
    }
}

class Pair{
    
    public int idx;
    
    public int start;
    
    public int duration;
    
    public Pair(int idx,int start,int duration){
        this.idx = idx;
        this.start = start;
        this.duration = duration;
    }
    
}