import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

class Solution {
    
    public int go(int idx){
        
        int count=0;
        
        for(int i=1;i<=idx;i++){

            int cnt=1;
            for(int j=1;j<=i;j++){
                cnt*=5;
            }
            count+=cnt;
        }
        count+=1;

        return count;
    }
    
    public int solution(String word) {
        
        
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String str=word;
        int answer=0;
        
        List<Character>arr = new ArrayList<>();
        
        arr.add('A');
        arr.add('E');
        arr.add('I');
        arr.add('O');
        arr.add('U');

        for(int i=0;i<str.length();i++){

            for(int j=0;j<arr.size();j++){
                if(arr.get(j)!=str.charAt(i)){
                    answer+=go(5-i-1);
                }
                else {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
        
        
        
    }
}