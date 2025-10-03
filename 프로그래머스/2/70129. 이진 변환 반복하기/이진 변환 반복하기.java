class Solution {
    public int[] solution(String s) {
        
        int cnt=0;
        int replace = 0;
        
        while(s.length()!=1){
            
            cnt++;
            
            int before = s.length();
            
            s = s.replaceAll("0","");
            
            replace += before - s.length();
            
            s = Integer.toString(s.length(),2);
        }
        
        int[] answer = {cnt,replace};
        
        return answer;
    }
}