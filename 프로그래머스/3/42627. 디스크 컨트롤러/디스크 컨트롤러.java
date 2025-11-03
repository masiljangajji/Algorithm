import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        
        Arrays.sort(jobs,(v1,v2)->{
            return v1[0]-v2[0];
        });
        
        PriorityQueue<Job>pq= new PriorityQueue<>(
            (v1,v2)->{
                if(v1.duration==v2.duration){
                    if(v1.time==v2.time)
                        return v1.number-v2.number;
                    return v1.time-v2.time;
                }
                return v1.duration-v2.duration;
            }
        );
        
        int time=0;
        int i=0;
        int answer=0;
        int n = jobs.length;
        
        
        while(true){
            
            if(i>=n&&pq.isEmpty())
                return answer/n;
            
            // 현재 시각까지 도착한 작업 전부 더하기
            while(i<n&&jobs[i][0]<=time){
                pq.add(new Job(i,jobs[i][0],jobs[i][1]));
                i++;
            }
            
            if(i<jobs.length&&pq.isEmpty()){
                pq.add(new Job(i,jobs[i][0],jobs[i][1]));
                time = jobs[i][0];
                i++;
                continue;
            }
            
            Job j = pq.poll();

            while(i<jobs.length&&j.duration+time>=jobs[i][0]){
                pq.add(new Job(i,jobs[i][0],jobs[i][1]));
                i++;
            }
            
            time+=j.duration;
            answer+=(time-j.time);
            
        }
        
    }
}

class Job{
    
    int number;
    int time;
    int duration;
    
    Job(int number,int time,int duration){
        this.number =number;
        this.time = time;
        this.duration = duration;
    }
    
}