import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        List<String>nums = new ArrayList<>();
        
        for(int n : array){
            nums.add(String.valueOf(n));
        }
        
        for(int i=0;i<commands.length;i++){           
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            answer[i] = getNum(nums,start-1,end-1,k-1);
        }
        
        return answer;
    }
    
    private int getNum(List<String>nums,int start,int end,int k){
        
        List<Integer> sorted = new ArrayList<>();
        for(int i=start;i<=end;i++){
            sorted.add(Integer.parseInt(nums.get(i)));
        }
        
        Collections.sort(sorted);
        
        return sorted.get(k);
    }
}