import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        
        for(int i=0;i<commands.length;i++){
            answer[i] = splitAndsort(array,commands[i]);    
        }
        
        return answer;
    }
    
    private int splitAndsort(int []array,int[]command){
        
        
        List<Integer>list = new ArrayList<>();
        
        for(int i=command[0]-1;i<command[1];i++){
            list.add(array[i]);
        }
        
        Collections.sort(list);
        return list.get(command[2]-1);
    }

    
}