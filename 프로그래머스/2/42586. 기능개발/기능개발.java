import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            q.add(new Pair(i,progresses[i]));
        }
        
        int total = 0;
        List<Integer>list= new ArrayList<>();
        
        while(!q.isEmpty()){
            int cnt=1;
            int time = check(q.poll(),total,speeds);
            total+=time;    
            
            // total 시간에 작업1이 완료된 것 
            while(!q.isEmpty()&&isValid(q.peek(),total,speeds)){
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean isValid(Pair p,int total,int[]speeds){
        return p.num+speeds[p.idx]*total>=100;
    }
    
    private int check(Pair p,int total,int []speeds){
        for(int i=total+1;;i++){
            if(p.num+speeds[p.idx]*i>=100)
                return i-total;
        }
    }
    
}


class Pair{
    
    int idx;
    int num;
    
    public Pair(int idx,int num){
        this.idx=idx;
        this.num=num;
    }
    
}