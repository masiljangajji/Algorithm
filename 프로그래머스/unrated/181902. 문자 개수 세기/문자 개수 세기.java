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
    public int[] solution(String my_string) {
        
       Map<Character,Integer>m=new HashMap<Character,Integer>();

        String str=my_string;


        for(char i='A';i<='Z';i++){
            m.put(i,0);
        }
        for(char i='a';i<='z';i++)
            m.put(i,0);
        
        for(int i=0;i<str.length();i++){
            m.put(str.charAt(i),m.get(str.charAt(i))+1);
        }
        
        List<Integer>li=new ArrayList<>(m.values());
        
        int []arr=new int[52];
        
        for(int i=0;i<li.size();i++){
            arr[i]=li.get(i);
        }
        
        return arr;
        
        
    }
}