import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> s = new HashSet<>();

        int num;
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                num = numbers[i]+numbers[j];
                s.add(num);
            }
        }
        
        return s.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }

    
}