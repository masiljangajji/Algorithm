class Solution {
    public int solution(int[] citations) {
        int Max=-123456789;
        for(Integer a:citations)
            Max=Math.max(Max,a);

        int ans=0;

        for(int i=0;i<Max;i++) {

            int h_cnt = 0;
            int hn_cnt = 0;

            for (int j = 0; j < citations.length; j++) {
                if (citations[j]>=i)
                    h_cnt++;
                else if(citations[j]<=i)
                    hn_cnt++;
            }

            if(h_cnt>=i&&hn_cnt<=i)
                ans=i;
        }
        
        return ans;
    }
}