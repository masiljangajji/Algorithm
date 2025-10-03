import java.util.*;

class Solution {
    
    private static final char CHARS[]={'A','E','I','O','U'};
    
    public int solution(String word) {
        
        int cnt=0;
        for(char ch : CHARS){
            
            List<String> list = generate(String.valueOf(ch));
            
            int idx = list.indexOf(word);
            
            if(idx==-1){
                cnt+=list.size();
                continue;
            }           
            
            return cnt+idx+1;
        }
        
        return generate("A").indexOf(word)+1;
    }
    
    public List<String> generate(String word){
        
        List<String>words = new ArrayList<>();
        
        words.add(word);
        
        // 종료 
        if(word.length()==5){
            return words;
        }
        
        // word = word + word +'A' , word + 'E' + word + 'I' + word + 'O' , word+'U'
        for(char ch : CHARS){
            words.addAll(generate(word+ch));
        }
        return words;
    }
    
}