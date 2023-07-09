class Solution {
    
    public static int[] go(int []arr, int [][]arr2){

        int []res = new int[arr2[0].length];


        for(int i=0;i<arr2[0].length;i++){

            int sum=0;
            for(int j=0;j<arr2.length;j++){
                sum+=arr[j]*arr2[j][i];
            }
            res[i]=sum;
        }

        return res;
    }
    
    
    public int[][] solution(int[][] arr, int[][] arr2) {
        
        int [][] answer= new int[arr.length][arr2[0].length];
        
        for(int i=0;i<arr.length;i++){
            answer[i]=go(arr[i],arr2);
        }
        
        
        return answer;
    }
}