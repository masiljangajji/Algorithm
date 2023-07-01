import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

class Solution {
    public int solution(String[] order) {
        
        Map<String,Integer>m=new HashMap<String,Integer>();

       m.put("iceamericano",4500);
        m.put("americanoice",4500);
        m.put("hotamericano",4500);
        m.put("americanohot",4500);
        m.put("icecafelatte",5000);
        m.put("cafelatteice",5000);
        m.put("anything",4500);
        m.put("americano",4500);
        m.put("hotcafelatte",5000);
        m.put("cafelattehot",5000);
        m.put("cafelatte",5000);
        
        int answer = 0;
        
        for(int i=0;i<order.length;i++){
            answer+=m.get(order[i]);
        }
        
        
        return answer;
        
        
    }
}