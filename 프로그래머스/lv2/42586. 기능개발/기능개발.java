import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Collections.fill;
import static java.util.Collections.reverseOrder;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        boolean [] check = new boolean[104];

        Arrays.fill(check,false);
        Map<Integer,Integer>m = new TreeMap<>();
        List<Integer> v= new ArrayList<>();
        
         for(int i=0;i<progresses.length;i++){
            m.put(i,0);
        }
        
        int here=0;

        while(true){

            boolean is_end =true;

            for(int i=0;i<progresses.length;i++){
                if(check[i]==false) {
                    is_end= false;

                    progresses[i] += speeds[i];
                    if (progresses[i] >= 100) {
                        check[i] = true;
                        m.put(i,1);
                    }
                }
            }

            if(is_end==true){
                int [] answer=v.stream().mapToInt(Integer::intValue).toArray();
                return answer;
            }

            int cnt=0;

            for(int i=0;i<progresses.length;i++){
                if(m.get(i)==1){
                    m.put(i,-1);
                    cnt++;
                }
                else if(m.get(i)==-1)
                    continue;
                else
                    break;
            }

            if(cnt!=0)
                v.add(cnt);

        }
        
    }
}