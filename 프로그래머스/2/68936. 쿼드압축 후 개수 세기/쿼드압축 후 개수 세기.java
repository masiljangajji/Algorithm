class Solution {
    
    private static int one=0;
    private static int zero=0;
    
    public int[] solution(int[][] arr) {
        
        check(arr,0,0,arr.length);
        
        return new int[]{zero,one};
    }
    
    private void check(int [][]arr,int X,int Y,int SIZE){
        
        int num = arr[Y][X];
        
        boolean flag = true;
        
        
        for(int i=Y;i<Y+SIZE;i++){
            for(int j=X;j<X+SIZE;j++){
                if(arr[i][j]!=num){
                    flag = false;
                    SIZE /=2;
                    check(arr,X,Y,SIZE);
                    check(arr,X,Y+SIZE,SIZE);
                    check(arr,X+SIZE,Y,SIZE);
                    check(arr,X+SIZE,Y+SIZE,SIZE);
                    return;
                }
            }
        }
        
        if(flag){
            if(num==0)
                zero++;
            else
                one++;
        }
        
    }
    
}