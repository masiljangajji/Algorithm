import java.util.*;
class Solution {
    
    private static final Map<String,List<Integer>>m= new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        buildMap(info);
        int idx=0;
        int[]answer = new int[query.length];
                
        for(String str : query){
            
            String s = str.replace(" and ","");
            String []split = s.split(" ");
            
            List<Integer>list = m.get(split[0]);
            
            if(list == null){
                answer[idx++] = 0;
                continue;
            }
            int score = Integer.parseInt(split[1]);
            answer[idx++] = list.size()-binarySearch(list,score);
        }
        return answer;
    }
    
    private int binarySearch(List<Integer>list,int score){     
        
        int start = 0;
        int end = list.size()-1;
        
        while(start<end){
               
            int mid = (start+end)/2;
                
            if(list.get(mid)<score)
                start = mid+1;
            else
                end = mid;
        }      
        
        if(list.get(start)<score)
            return list.size();
        
        return start;
    }
    
    private void buildMap(String []info){
        
        for(String s: info){
            String[]tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length-1]);
            buildString(tokens,"",0,score);
        }
        
        for(List<Integer>list : m.values()){
            Collections.sort(list);
        }
        
    }
    
    private void buildString(String[]tokens,String str,int depth,int score){
        
        if(depth==tokens.length-1){
            m.putIfAbsent(str,new ArrayList<Integer>());
            m.get(str).add(score);
            return;
        }
                
        buildString(tokens,str+tokens[depth],depth+1,score);
        buildString(tokens,str+"-",depth+1,score);
    }
    
}