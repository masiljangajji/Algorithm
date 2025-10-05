import java.util.*;
class Solution {
    
    private static final boolean[] visited = new boolean[7];
    
    private static final Set<Integer> nums = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 순열  = 9!
        int size = numbers.length();
        
        for(int i=1;i<=size;i++){
            permutation(numbers,new char[i],0,i);    
        }
        
        Iterator<Integer> it = nums.iterator();
        
        while(it.hasNext()){
            int n = it.next();
            //System.out.println(n);
            
            if(isPrime(n))
                answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(int num){
        
        int cnt =0;
        
        for(int i=1;i<=num;i++){
            if(num%i==0)
                cnt++;
        }
        
        return cnt==2?true:false;
    }
    
    private void permutation(String numbers,char []ch, int depth,int size){
        
        if(depth==size){
            
            int n = Integer.parseInt(new String(ch));
            nums.add(n);
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            
            if(visited[i])
                continue;
            
            visited[i] = true;
            ch[depth] = numbers.charAt(i);
            permutation(numbers,ch,depth+1,size);
            visited[i] = false;
        }
        
    }
    
}