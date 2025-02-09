import java.util.*;
import java.lang.*;

class Solution {
    public String solution(int n) {
        
        String answer = "";
        
        StringBuilder stb = new StringBuilder();
        
        while(n>0){
            
            int num = n%3;
            
            if(num==1){
                stb.append("1");
            }
            
            if(num==2){
                stb.append("2");
            }
            
            if(num==0){
                stb.append("4");
                n--;
            }
            
            n/=3;
            
        }
        
        return stb.reverse().toString();
    }
}