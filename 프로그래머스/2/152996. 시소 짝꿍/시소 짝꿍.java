import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int w : weights) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }

        double[] factors = {2.0 / 3, 2.0 / 4, 3.0 / 4}; // 비율 값

        // 3️⃣ 몸무게별로 시소 짝꿍 탐색
        for (int w : countMap.keySet()) {
            int count = countMap.get(w);

            // 같은 몸무게끼리 (조합 nC2)
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }

            // 다른 몸무게와 짝꿍 찾기
            for (double factor : factors) {
                double targetWeight = w * factor;
                if (targetWeight == (int) targetWeight && countMap.containsKey((int) targetWeight)) {
                    answer += (long) count * countMap.get((int) targetWeight);
                }
            }
        }

        return answer;
    }
}