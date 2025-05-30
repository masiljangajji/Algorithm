import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        // 첫 컬럼, 기본 키 
        // 해시 함수 col,row_begin, row_end 입력 받음 
        // 테이블 행은 , col 컬럼의 값을 기준으로 오름차순 정렬, 만약 값 동일하면 pk값 기준으로 내림차순 정렬
        
        // 정렬된 데이터에서 S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합으로 정의
        // row_begin <= i <= row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값 해시 값으로서 변환 
        
        // 2 2 6
        // 1 5 10
        // 4 2 9
        // 3 8 3 
    
        Arrays.sort(data,(a,b)-> {
            
            int cmp = Integer.compare(a[col-1],b[col-1]);
                if(cmp!=0){
                    return cmp;
                }
            
            return Integer.compare(b[0],a[0]);
            
        });
        

        Queue<Integer> q = new LinkedList<>();
                
        for(int i=row_begin-1;i<=row_end-1;i++){
            int sum = 0;
            for(int j=0;j<data[i].length;j++){
                sum+=(data[i][j]%(i+1));
            }
            q.add(sum);
        }
        
        int answer = q.poll();
        
        while(!q.isEmpty()){
            answer ^= q.poll();
        }
    
        
        // 정렬된 데이터에서 S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합으로 정의
        // row_begin <= i <= row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값 해시 값으로서 변환 
        
        return answer;
    }
}