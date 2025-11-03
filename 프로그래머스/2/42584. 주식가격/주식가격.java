import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        Arrays.fill(answer,-1);
        
        Stack<Pair>st = new Stack<>();

        
        for(int i=0;i<prices.length;i++){   
            
            int n = prices[i];
            while(!st.isEmpty()&&st.peek().num>n){
                answer[st.peek().idx]=i-st.peek().idx;
                st.pop();
            }
            st.add(new Pair(i,n));
        }
        
        for(int i=0;i<prices.length;i++){
            if(answer[i]==-1){
                answer[i]=prices.length-1-i;
            }
        }
        
        return answer;
    }
}

class Pair{
    
    public int idx;
    public int num;
    
    public Pair(int idx,int num){
        this.idx = idx;
        this.num = num;
    }
    
}