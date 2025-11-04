class Solution {
    
    public int solution(int[] numbers, int target) {
        
        int answer = 0;
        return dp(0,target,numbers,0);
    }
    
    public int dp(int start,int target,int[]numbers,int result){
        
        if(start==numbers.length){
            if(result==target)
                return 1;
            return 0;
        }
        
        int cnt=0;
        
        cnt+=dp(start+1,target,numbers,result+numbers[start]);
        cnt+=dp(start+1,target,numbers,result+(numbers[start]*-1));
        return cnt;
    }
    
}