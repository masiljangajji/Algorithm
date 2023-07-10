import java.util.*;
import static java.util.Arrays.sort;
class Solution {
    
    public String solution(int[] numbers) {
        
        String answer="";
        String[]str= new String[numbers.length];
        
        boolean flag= true;
        
        for(int i=0;i<numbers.length;i++){
            str[i]=Integer.toString(numbers[i]);
            if(numbers[i]!=0)
                flag=false;
        }
        
        if(flag==true)
            return "0";

        sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        for(String a:str)
            answer+=a;
        
       

       
        return answer;
    }
}


// 9 5 