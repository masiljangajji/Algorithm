class Solution {
    public int[] solution(int brown, int yellow) {
        
        int row = 1;
        
        // 갈색 = (width+height-2) x 2 
        // 노란색 = width x height - [ (width+height-2) x 2 ]
        
        while(true){

            if(yellow%row!=0){
                row++;
                continue;
            }
            
            int num = row*2 + ((yellow/row)+2)*2;
            if(num == brown){
                return new int[]{(yellow/row)+2,row+2};
            }
            row++;
        }
        
    }
}