import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        
        Set<Integer>nums = new HashSet<>();
        
        combi(-1,new ArrayList<Integer>(),numbers,nums);
        List<Integer>list = new ArrayList<>(nums);
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void combi(int start,List<Integer>list,int[]numbers,Set<Integer>nums){
        
        if(list.size()==2){
            int sum = list.get(0)+list.get(1);
            nums.add(sum);
            return;
        }
        
        for(int i=start+1;i<numbers.length;i++){
            list.add(numbers[i]);
            combi(i,list,numbers,nums);
            list.remove(list.size()-1);
        }
        
    }
    
}