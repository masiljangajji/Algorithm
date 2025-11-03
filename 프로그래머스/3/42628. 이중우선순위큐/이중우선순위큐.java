import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        PriorityQueue<Integer> desc = new PriorityQueue<>((v1,v2)->v2-v1);
        PriorityQueue<Integer> incr = new PriorityQueue<>((v1,v2)->v1-v2);
        
    
        int n=0;
        int i=0;
        
        for(String s : operations){
            String []strs = s.split(" ");
            
            if(strs[0].equals("I")){
                int num = Integer.parseInt(strs[1]);
                incr.add(num);
                desc.add(num);
                n++;
                continue;
            }
            
            if(n>0){
                // 최댓값 삭제
                if(strs[1].equals("1")){
                    int value = desc.poll();
                    incr.remove(value);
                    n--;
                }else{
                    // 최솟값 삭제
                    int value = incr.poll();
                    desc.remove(value);
                    n--;
                }
            }
            
            if(n==0){
                desc.clear();
                incr.clear();
            }
        }
            
        

        if(!desc.isEmpty()&&!incr.isEmpty()){
            answer[0]=desc.peek();
            answer[1]=incr.peek();
        }else if(!desc.isEmpty()){
            answer[0]=desc.peek();
            answer[1]=desc.peek();
        }else if(!incr.isEmpty()){
            answer[0]=incr.peek();
            answer[1]=incr.peek();
        }
        
        return answer;
    }
}

