class Solution {
    
    int [] arr= new int[600001];
    
    public int solution(int n) {
        int answer = 0;
        
            
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        
        for(int i=3;i<=n;i++){
            arr[i]=(arr[i-1]+arr[i-2])%1000000007;
        }
        
        
        return arr[n];
    }
    
}