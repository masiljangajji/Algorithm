import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey>0){
            
            int current = storey%10;
            int next = (storey/10)%10;
            
            if(current>5){ // 5이상이면 더해주기 
                answer+=(10-current);
                storey+=(10-current);
            }else if(current<5){ // 5이하면 빼주기 
                answer+=current;
                storey-=current;
            }else if(current == 5 && next>=5){ // 5고 다음 숫자가 5이상이면 더해주기 
                answer+=(10-current);
                storey+=(10-current);
            }else{ // 5고 다음 숫자가 5 이하면 빼주기 
                answer+=current;
                storey-=current;
            }
            
            storey/=10;
        }
        
                
        return answer;
    }
}