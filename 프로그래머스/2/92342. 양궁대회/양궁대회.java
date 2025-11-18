import java.util.*;
class Solution {
    
    public int[] solution(int n, int[] info) {
    
        int []answer = dfs(0,new int[11],n,info);
        if(answer==null){
            return new int[]{-1};
        }
        return answer;
    }
    
    private int []dfs(int idx,int []hits,int n,int []apeach){
        
        if(idx==hits.length){
            if(n>0)
                return null;
            if(scoreDiff(hits,apeach)<=0)
                return null;
            return Arrays.copyOf(hits,hits.length);
        }
        
        int maxDiff =0;
        int []result = null;
        
        for(int hit=0;hit<=n;hit++){
            hits[idx]=hit;
            int[]ryan = dfs(idx+1,hits,n-hit,apeach);
            
            if(ryan==null)
                continue;
            
            int diff = scoreDiff(ryan,apeach);
            if(diff>maxDiff||(diff==maxDiff&&checkPriority(result,ryan))){
                maxDiff=diff;
                result = ryan;
            }
            
        }
        
        return result;
        
    }
    
    private int scoreDiff(int []ryan,int[] apeach){
        
        int diff=0;
        
        for(int i=0;i<ryan.length;i++){
            
            if(apeach[i]==0&&ryan[i]==0)
                continue;
            
            if(ryan[i]<=apeach[i]){
                diff-=(10-i);
            }else 
                diff+=(10-i);
            
        }
        return diff;
    }
    
    private boolean checkPriority(int []base,int []comp){
        for(int i=10;i>=0;i--){
            if(base[i]==comp[i])
                continue;
            return comp[i]>base[i];
        }
        return false;
    }
    
}