class Solution {
    
    private static final int[][]arr= new int[1001][1001];
    
    private static int cnt=1;
    
    public int[] solution(int n) {
        
        generate(n);
        int[] answer = new int[cnt-1];
        
        int num=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]!=0)
                    answer[num++] = arr[i][j];
            }
        }
        
        return answer;
    }
    
    public void generate(int n){
        
        int dir = 0;
        var p = new Pair(-1,0);
        
        while(n>0){
            
            if(dir==0)
                down(n,p);
            
            if(dir==1)
                right(n,p);
                
            if(dir==2)
                rightUp(n,p);
            
            dir++;
            dir%=3;
            n--;
        }
        
    }
    
    private void down(int n,Pair p){
        
        for(int i=0;i<n;i++){
            arr[++p.y][p.x] = cnt++;
        }
    }
    
    private void right(int n,Pair p){
        for(int i=0;i<n;i++){
            arr[p.y][++p.x] = cnt++;
        }
    }
    
    private void rightUp(int n,Pair p){
        for(int i=0;i<n;i++){
            arr[--p.y][--p.x] = cnt++;
        }
    }   
}

class Pair{
    
    public int y;
    public int x;
    
    public Pair(int y,int x){
        this.y=y;
        this.x=x;
    }
    
}