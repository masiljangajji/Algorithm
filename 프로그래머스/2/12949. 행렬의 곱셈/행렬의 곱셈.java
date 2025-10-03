class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0;i<arr1.length;i++){
            answer[i]= calc(arr1[i],arr2);
        }
        
        return answer;
    }
    
    public int[] calc(int[]arr,int[][]arr2){
        
        int []result = new int[arr2[0].length];
    
        for(int i=0;i<arr2[0].length;i++){
            for(int j=0;j<arr2.length;j++){
                result[i]+=arr[j]*arr2[j][i];   
            }
        }
        
        
        return result;
    }
    
}