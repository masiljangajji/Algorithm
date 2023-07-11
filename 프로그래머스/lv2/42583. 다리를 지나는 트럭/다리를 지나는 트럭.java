import java.util.*;

class Solution {
    
    public static class Pair{

        int go;
        int num;

        Pair(int num ,int go){
            this.num=num;
            this.go=go;
        }

    }
    
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    
       Queue<Integer> q = new LinkedList<>();
       List<Pair> order = new ArrayList<>();

        int sum = 0;
        
        for (int i = 0; i < truck_weights.length; i++)
            q.add(truck_weights[i]);

        for(int i=1;;i++){

            List<Integer>del = new ArrayList<>();

            for (int k = 0; k < order.size(); k++) {
                if (order.get(k).go + 1 == bridge_length) {
                    del.add(k);
                    sum-=order.get(k).num;
                } else
                    order.set(k,new Pair(order.get(k).num,order.get(k).go+1));
            }

            for(int k=0;k<del.size();k++){
                order.remove(0);
            }

            if(sum+q.peek()>weight){
                continue;
            }
            else{
                int number= q.poll();
                sum+=number;
                order.add(new Pair(number,0));
            }

            if(q.isEmpty()){
                return i+bridge_length;
            }


        }
        
    }
}