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
    public int solution(int k, int[] tangerine) {
        
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        
        
        for(int i=0;i<tangerine.length;i++){
            m.put(tangerine[i],(m.get(tangerine[i]))==null?1:m.get(tangerine[i])+1);
        }
        
        
        List<Integer>arr= new ArrayList<>(m.values());

        sort(arr,reverseOrder());
        
        int sum=0;
        int answer = 0;
        
        for(int i=0;i<arr.size();i++){
            if(k>sum){
                sum+=arr.get(i);
                answer++;
            }
            else
                break;
        }
        
        
        return answer;
    }
}