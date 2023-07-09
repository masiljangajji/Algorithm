import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer,Integer>m = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
            m.put(nums[i],1);
        
        
        List<Integer>arr= new ArrayList<>(m.keySet());
        
        if(arr.size()<=nums.length/2){
            return arr.size();
        }
        else 
            return nums.length/2;
        
    }
}