class Solution {
    public int solution(int[] numbers, int target) {
        return dp(numbers,numbers[0],0,target,0)+dp(numbers,numbers[0]*-1,0,target,0);
    }
    
    private int dp(int[]numbers,int number,int depth,int target,int sum){
                
        sum +=number;
        
        if(depth==numbers.length-1){   
            if(sum==target)
                return 1;
            else
                return 0;
        }
        
        depth++;
        
        return dp(numbers,numbers[depth],depth,target,sum) 
            + dp(numbers,numbers[depth]*-1,depth,target,sum);
    }
    
}