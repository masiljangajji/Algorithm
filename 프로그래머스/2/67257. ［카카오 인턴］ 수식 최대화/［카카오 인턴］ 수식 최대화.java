import java.util.*;

class Solution {
    
    private static final boolean[]visited= new boolean[3];
    
    private static final char[][]ops = new char[6][3];
    
    private static int cnt = 0;

    
    public long solution(String expression) {
        
        StringTokenizer stk = new StringTokenizer(expression,"+-*",true);
        
        List<String>list= new ArrayList<>();
        
        while(stk.hasMoreTokens()){
            list.add(stk.nextToken());
        }
        
        permutation(new char[3],0);
        
        long answer = 0;

        for(int i=0;i<6;i++){
            long value = Math.abs(calc(new ArrayList<>(list),ops[i]));
            answer = Math.max(value,answer);
        }

        return answer;
    }
    
    private long calc(List<String>tokens,char[]ops){
        
        for(char op:ops){
            for(int i=0;i<tokens.size();i++){
             
                if(tokens.get(i).equals(String.valueOf(op))){
                    
                    long left = Long.parseLong(tokens.get(i-1));            
                    long right = Long.parseLong(tokens.get(i+1));
                    
                    long result = switch(op){
                            case '+' ->  left+right;
                            case '-' ->  left-right;
                            case '*' ->  left*right;
                            default -> 0;
                    };
                    
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1,String.valueOf(result));
                    i-=2;
                }
            }
        }
        
        return Long.parseLong(tokens.get(0));
        
    }
    
    private void permutation(char[]arr,int depth){
        
        if(depth==3){
            for(int i=0;i<arr.length;i++){
                ops[cnt][i] = arr[i];
            }
            cnt++;
            return;
        }
        
        for(int i=0;i<3;i++){
            
            if(visited[i])
                continue;
            
            visited[i] = true;        
            
            if(i==0)
                arr[depth]='+';
            else if(i==1)
                arr[depth]='-';
            else
                arr[depth]='*';
            
            permutation(arr,depth+1);
            visited[i] = false;
        }
        
    }
    
}