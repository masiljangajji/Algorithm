import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int answer = 0;
        
        
        // case1 서로 선물을 주고 받았더라면 
        // 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다
        
        // case2 선물 주고받은 기록이 없거나, 같다면 
        // case 2-1 선물 지수가 더 큰 사람이 작은 사람에게 선물을 받는다 
        
        // case2-2 선물지수도 같으면 선물 안주고 받는다 
        
        // 선물지수 = 자신이 친구들에게 준 선물 수 - 받은 선물 
        // 선물지수는 -도 가능 
        
        
        // 선물 준 사람, 받은 사람 먼저 구분해서 저장
        // 어떻게 구분? -> 
        
        Map<String,Integer> nameConverter = new HashMap<>();
        
        
        int cnt=0;
        int frinedSize= friends.length;
        for(String name : friends){
            nameConverter.put(name,cnt);
            cnt++;
        }
        
        int[][]arr= new int[frinedSize][frinedSize];
        int []pIndex = new int[frinedSize];
        
        for(int i=0;i<gifts.length;i++){
            String[] strs = gifts[i].split(" ");
            arr[nameConverter.get(strs[0])][nameConverter.get(strs[1])]++; // [준 사람][받은 사람] ++
            pIndex[nameConverter.get(strs[0])]++; 
            pIndex[nameConverter.get(strs[1])]--; // 선물지수 
        }
        
        // case1 서로 선물을 주고 받았더라면 
        // 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다
        
        int[] result = new int[frinedSize];
        
        for(int i=0;i<friends.length-1;i++){
            
            for(int j=i+1;j<friends.length;j++){
                
                if(arr[i][j]!=0||arr[j][i]!=0){ // 선물 주고 받음 
                    
                    if(arr[i][j]>arr[j][i]){
                        result[i]++;
                        continue;
                    }
                    else if(arr[i][j]<arr[j][i]){
                        result[j]++;
                        continue;
                    }
                        
                } 
                
                // 선물 주고받은게 같거나, 없으면 
                    
        // case2-2 선물지수도 같으면 선물 안주고 받는다 
                
                
                if(pIndex[i]==pIndex[j])
                    continue;
                
                
        // case 2-1 선물 지수가 더 큰 사람이 작은 사람에게 선물을 받는다         
                if(pIndex[i]>pIndex[j]){
                    result[i]++;
                }else
                    result[j]++;
                
            }
            
        }
        
        for(Integer n : result)
            answer = Math.max(n,answer);
        
        return answer;
    }
}