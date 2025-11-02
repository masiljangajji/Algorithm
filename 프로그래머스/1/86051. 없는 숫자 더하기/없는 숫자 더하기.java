class Solution {
    public int solution(int[] numbers) {
        
        
        // 0 ~ 9 까지의 숫자의 일부가 들어간 배열 
        int []arr= new int[10];
        
        for(int n : numbers){
            arr[n]++;
        }
        
        int sum =0;
        
        for(int i=1;i<=9;i++){
            if(arr[i]==0)
                sum+=i;
        }
        
        return sum;
    }
}