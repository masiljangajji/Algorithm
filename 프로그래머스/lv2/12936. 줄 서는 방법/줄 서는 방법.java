class Solution {
    
    static boolean []visit = new boolean[21];
    
    public int[] solution(int n, long k) {
        
        long [] arr = new long[21];

        arr[0]=1;
        arr[1]=1;
        arr[2]=2;

        for(int i=3;i<=20;i++){
            arr[i]=arr[i-1]*i;
        }
        
        int [] ans = new int[n];


        for(int i=0;i<n;i++){
            for(int j=1;j<=n;j++){

                if(visit[j]==true)
                    continue;

                if(arr[n-1-i]<k)
                    k-=arr[n-1-i];
                else{
                    ans[i]=j;
                    visit[j]=true;
                    break;
                }
            }
        }
        
        return ans;
    }
}