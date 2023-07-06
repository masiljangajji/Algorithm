class Solution {
    
    public long solution(int k, int d) {
        long answer = 0;

        long idx;
        
        long k2=k;
        long d2 =d;
        

        for(long i=0;i<=d;i+=k2){
            long check=(d2*d2)-(i*i);

            double sum=Math.sqrt(check);

            long ans = (long)sum/k2;
            ans++;

            answer+=ans;
        }
        
        return answer;
    }
}