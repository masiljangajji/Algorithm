class Solution {
    public long solution(int n, int[] tops) {
        
        // 길이 1 정삼각형 , 2n+1 개를 이어붙여 윗변 길이가 n
        // 아랫변 길이가 n+1 사다리꼴 
        
        // 사다리꼴 윗변과 변을 공유하는 n 개의 정삼각형 중 일부의 위쪽에 같은 크기 정삼각형 붙여 새로운 모형 
        
        // 마름모 타일로 빈곳 없이 채운다. 
        
        long []dp = new long[2*n+1];
        
        dp[0] = 1L;
        dp[1] = 2L;
        
        if(tops[0]==1){
            dp[1]= 3L; 
        }
            
        int tIdx = 0;
        
        for(int i=2;i<2*n+1;i++){
            
            if(i%2==1){
                tIdx++;
                if(tops[tIdx]==1){
                    dp[i] = (dp[i-1]*2+dp[i-2])%10007;    
                    continue;
                }
            }
            
            dp[i] = (dp[i-1]+dp[i-2]) % 10007;    
        }
        
    
        
        return dp[2*n];
    }
}