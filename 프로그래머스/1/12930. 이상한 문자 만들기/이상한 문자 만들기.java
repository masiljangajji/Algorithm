class Solution {
    public String solution(String s) {
        
        // 짝수번째 알파벳 -> 대문자
        // 홀수번째 알파벳 -> 소문자 
        
        StringBuilder sb = new StringBuilder();
        
        int cnt=0;
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            sb.append(change(ch,cnt));
            
            if(ch==' '){
                cnt=0;
                continue;
            }
            
            cnt++;
        }
        
        return sb.toString();
    }
    
    public char change(char ch,int idx){
        
        if(idx%2==0)
            return Character.toUpperCase(ch);
        
        return Character.toLowerCase(ch);
        
    }
    
}