import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] order) {
        
        int answer = 0;
        
        // 택배상자는 크기가 모두 같음 1~n번 상자까지 있음  순서대로 전달됨
        
        // 배달하는 순서와 상자가 실려 있는 순서가 맞아야 함 
        // 맞지 않는 경우 보조 컨테이너에 넣음 
        
        // 보조 컨테이너는 앞뒤로 이동이 가능 , but 맨 앞의 상자만 뺄 수 있음 
        
        // 보조 컨테이너 써도 순서대로 못하면 , 더 이상 상자 안넣음 
        
        
        
        // 보조 컨테이너 = Stack 
        
        Stack<Integer>st = new Stack<>();
        
        int cnt = 1;
        int idx= 0;
        
        while(cnt<= order.length){ // idx = order 인덱스 
            
            while(order[idx]==cnt){
                cnt++;
                idx++;
            }
            
            // 보조 컨테이너가 뺄 수 있으면 뺌 
            if(!st.isEmpty()){
                while(st.peek()==order[idx]){
                    st.pop();
                    idx++;
                    if(st.isEmpty()){
                        break;
                    }
                }
            }
            
            st.push(cnt);
            cnt++;
        }
        
        if(!st.isEmpty()&&idx< order.length){
            while(st.peek()==order[idx]){
                st.pop();
                idx++;
                if(st.isEmpty()){
                    break;
                }
            }
        }
        
        
        return idx;
    }
}