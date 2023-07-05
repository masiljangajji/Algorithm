import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class go{

        int priority;
        int idx;

        go(int priority,int idx){
            this.priority=priority;
            this.idx=idx;
        }
    }

class Solution {
    public int solution(int[] priorities, int location) {
        int check=0;
        Queue<go> q= new LinkedList<>();
        
        for(int i=0;i<priorities.length;i++){
            q.add(new go(priorities[i],i));
        }
        
        while(!q.isEmpty()){
            int pro=q.peek().priority;
            int here = q.peek().idx;
            q.poll();

            boolean flag= true;
            Iterator<go> iter = q.iterator();
            while(iter.hasNext()){
                int a=iter.next().priority;
                if(pro<a){
                    flag=false;
                    break;
                }
            }

            if(flag==false){
                q.add(new go(pro,here));
            }
            else{
                check++;
                if(here==location) {
                    return check;
                }
            }


        }
        
        return 1;
        
    }
}