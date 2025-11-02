class Solution {
    public int solution(int n) {
        int answer = 0;

        int left = 0;
        int right = 1;
        
        if(n<=1)
            return n;
        
        for(int i=2;i<=n;i++){
            answer = (left + right)%1234567;
            left = right;
            right = answer;
        }

        
        return answer;
    }
}