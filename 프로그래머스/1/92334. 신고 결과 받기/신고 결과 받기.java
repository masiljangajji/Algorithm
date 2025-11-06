import java.util.*;
class Solution {
    
    private Map<String,Set<String>> m = new HashMap<>();
    
    public int[] solution(String[] list, String[] report, int k) {
        
        initMap(list);
        buildMap(report);
        
        int []answer = new int[list.length];
        
        Map<String,Integer> emailMap = new HashMap<>();
        
        for(String id:list){
            // 이게 K보다 크면 정지
            Set<String> reportSet = m.get(id);
            if(reportSet.size()>=k){
                for(String ans : reportSet){
                // 신고한 사람들은 메일을 받아야 함
                    emailMap.putIfAbsent(ans,0);
                    emailMap.put(ans,emailMap.get(ans)+1);
                }
            }
        }
        
        int idx=0;
        for(String id:list){
            if(emailMap.containsKey(id)){
                answer[idx++] = emailMap.get(id);
                continue;
            }
            answer[idx++] =0;
        }
        
        
        return answer;
    }
    
    private void initMap(String[]list){
        for(String id:list){
            m.put(id,new HashSet<String>());            
        }
    }
    
    private void buildMap(String[]report){
        for(String s : report){
            String[] sub = s.split(" ");
            Set<String>set = m.get(sub[1]);
            set.add(sub[0]);
        }
    }
    
}