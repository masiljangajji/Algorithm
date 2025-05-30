import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // n 명으로 연속되는 공격을 `순서대로` 막는다
        
        // n명의 병사, enemy[i] = 적의 숫자
        // 병사를 소모하여 enemy[i] 만큼의 적을 막을 수 있다 
        
        // 남은 병사 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료됩니다.
        
        // 스킬 사용하면, 그냥 한번 막을 수 있음 
        // 이건 K번 사용 가능 함 
        
        // 최대한 많은 라운드를 막아야 함 
        
        // 길이가 백만임 -> 브루트포스 불가능 -> DP 스럽게 
        // 순서대로 막아야 하니 -> 정렬은 불가능 -> 원본 배열을 복제해서 그걸 정렬시키고 처리하기?
        
        // 처음을 무조건 막는다? -> 그후에 처음보다 큰 숫자가 나오면 MAX 갱신하고 막는다
        // n<k면 막는다
        
        
        // 어떻게 가능한가 -> 내가 만날 수 중에, 가장 큰 숫자를 PASS 하면 된다 
        // 누적합으로 가면서 PQ에 하나씩 넣어
        // 누적합 -> 합치다가 n을 넘어서면 PQ에서 하나 빼와 그리고 K--
        // PQ -> 계속 넣다가 트리거받으면 하나 빼 와 
        
        int max = 0;
        
        if(k>=enemy.length){
            return enemy.length;
        }
        
        long sum=0;
        
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int en : enemy){
            // 누적합 
            sum+=en;
            // pq 
            q.add(en);
            
            if(sum>n){
                
                if(k>0){
                        int peek = q.peek();
                        sum-=peek;
                        q.poll();
                        k--;        
                }else{
                    break;
                }
            
            }
            
            answer++;
        }
        
        return answer;
    }
}