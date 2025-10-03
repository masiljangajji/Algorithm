import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 123456789;
        
        for(int i=1;i<=s.length();i++){
                        
            int cnt = encapsulate(s,i);
            answer = Math.min(cnt,answer);
        }
        
        return answer;
    }
    
    public int encapsulate(String s,int n){
                
        Queue<String>q = new LinkedList<>();
        
        int i = 0;
        
        while(i+n<s.length()){
            q.offer(s.substring(i,i+n));    
            i+=n;
        }
        
        if(s.length()-i>0){
            q.offer(s.substring(i));
        }
        
        
        int cnt=1;
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            
            String str = q.poll();
            
            if(str.equals(q.peek())){
                cnt++;
            }else{
                
                if(cnt>1)
                    sb.append(cnt).append(str);    
                else
                    sb.append(str);    

                cnt=1;
            }
        }
        
        return sb.length();
    }
    
}