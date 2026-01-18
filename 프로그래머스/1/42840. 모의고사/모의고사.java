import java.util.*;

class Solution {
    
    private static int max=0;
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int [] one = {1,2,3,4,5};
        int [] two = {2,1,2,3,2,4,2,5};
        int [] three = {3,3,1,1,2,2,4,4,5,5};
        
        List<Pair>list = new ArrayList<>();
        
        list.add(check(answers,one,1));
        list.add(check(answers,two,2));
        list.add(check(answers,three,3));
        
           
        return list.stream()
            .filter(v->v.cnt==max)
            .mapToInt(v->v.num)
            .toArray();
    }
    
    
    
    private Pair check(int []answers,int[]arr,int num){
        
        int cnt=0;
        int idx=0;
                
        for(int n : answers){
            if(n==arr[idx%arr.length]){
                cnt++;
            }
            idx++;
        }
        
        max = Math.max(cnt,max);
        
        return new Pair(cnt,num);
    }
}

class Pair{
    
    int cnt;
    int num;
    
    public Pair(int cnt,int num){
        this.cnt=cnt;
        this.num=num;
    }
    
}