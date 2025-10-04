import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // 1 2 3 4 5
        // 2 1 2 3 2 4 2 5 
        // 3 3 1 1 2 2 4 4 5 5 
        
        int []p1 = {1,2,3,4,5};
        int []p2 = {2,1,2,3,2,4,2,5};
        int []p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int c1,c2,c3;
        
        c1=c2=c3=0;
        
        for(int i=0;i<answers.length;i++){
            
            int num = answers[i];
            
            if(p1[i%p1.length]==num){
                c1++;
            }   
            
            if(p2[i%p2.length]==num){
                c2++;
            }   
            if(p3[i%p3.length]==num){
                c3++;
            }   
        }
        
        
        List<Integer>list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        
        int MAX = Collections.max(list);
        
        List<Integer>answer = new ArrayList<>();
        
        for(int i=0;i<list.size();i++){
            if(MAX==list.get(i)){
                answer.add(i+1);
            }
        }
        
        int [] ans = new int[answer.size()];
        
        for(int i=0;i<answer.size();i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}