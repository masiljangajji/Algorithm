import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int len = s.length();
        int min = len;
        
        for(int i=1;i<=len/2;i++){
            min = Math.min(min,convert(s,i,len,s.substring(0,i)));
        }
        
        return min;
    }
    
    private int convert(String s,int n,int len,String current){
        
        int i=n;
        int cnt=1;
        
        String str="";
        
        StringBuilder sb= new StringBuilder();
        boolean flag = true;
        
        while(flag){
            
            if(i+n>=len){
                str = s.substring(i);
                flag=false;
            }
            else
                str = s.substring(i,i+n);
                        
            if(str.equals(current))
                cnt++;
            else {
                if(cnt>1){
                    sb.append(cnt);
                    cnt=1;
                }
                sb.append(current);
            }
            current = str;
            i+=n;
        }
        
        
        if(cnt>1){
            sb.append(cnt);
        }
        
        sb.append(str);
                
        return sb.toString().length();
    }
    
}