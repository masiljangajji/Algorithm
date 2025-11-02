import java.util.*;

class Solution {

    int [][]maxMem = new int[202][202];
    int [][]minMem = new int[202][202];
    
    public int solution(String []arr) {
     
        for(int i=0;i<202;i++){
            Arrays.fill(maxMem[i],Integer.MIN_VALUE);
            Arrays.fill(minMem[i],Integer.MIN_VALUE);
        }
    
        return max(0,arr.length,arr);
    }
    
    public int max(int start,int end,String []arr){
        
        if(maxMem[start][end]!=Integer.MIN_VALUE)
            return maxMem[start][end];
        
        if(end-start==1)
            return Integer.parseInt(arr[start]);
        
        int max = Integer.MIN_VALUE;
        for(int i=start+1;i<end;i+=2){
            int l = max(start,i,arr);
            int v;
            
            if(arr[i].equals("+")){
                int r = max(i+1,end,arr);
                v = l+r;
            }else{
                int r= min(i+1,end,arr);
                v = l - r;
            }
            
            max =Math.max(v,max);
        }
        
        return maxMem[start][end] = max;
    }
    
    public int min(int start,int end,String[]arr){
        
        if(minMem[start][end]!=Integer.MIN_VALUE)
            return minMem[start][end];
        
        if(end-start==1)
            return Integer.parseInt(arr[start]);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=start+1;i<end;i+=2){
            int l = min(start,i,arr);
            int v;
            
            if(arr[i].equals("+")){
                int r = min(i+1,end,arr);
                v = l+r;
            }else{
                int r= max(i+1,end,arr);
                v = l - r;
            }
            
            min =Math.min(v,min);
        }
        
        return minMem[start][end] = min;        
        
    }
    


    
}