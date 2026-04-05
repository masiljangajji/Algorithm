import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 2xN 명의 사원들은 N명씩 두 팀으로 나눠 숫자 게임 
        

        
      List<Integer> a = Arrays.stream(A)
          .boxed()
          .sorted((v1, v2) -> v2 - v1)
          .collect(Collectors.toList());
        
      List<Integer> b = Arrays.stream(B)
          .boxed()
          .sorted((v1, v2) -> v2 - v1)
          .collect(Collectors.toList());
        
        
        // B의 앞 부분이 더 크다 -> 그냥 이기면 됨 
        // A가 더 크다 -> 모든 경우에 대해서 질 수 밖에 없음, B의 뒷부분에서 -1, A 앞부분에서 +1 
        
        Deque<Integer> dq1 = new ArrayDeque<>(a);
        Deque<Integer> dq2 = new ArrayDeque<>(b);
        
        while(!dq1.isEmpty()){
            
            int n = dq1.peek();
            int m = dq2.peek();
            
            if(n>=m){ // A가 모든 경우에 대해서 이기거나 비기면  
                dq1.removeFirst();
                dq2.removeLast();
                continue;
            }
            
            dq1.removeFirst();
            dq2.removeFirst();
            answer++;
        }
        
        return answer;
    }
}