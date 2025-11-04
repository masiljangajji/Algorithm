import java.util.*;
class Solution {
    
    Map<String,Boolean> m = new HashMap<>();
    
    public int solution(String begin, String target, String[] words) {
        
        // begin에서 하나의 알파벳만 바꾼게 words에 있다면 변경을 해라 
        
        Queue<Pair>q=new LinkedList<>();
        
        q.add(new Pair(begin,0));
        m.put(begin,true);
        
        while(!q.isEmpty()){
            Pair p = q.poll();
        
            if(p.word.equals(target))
                return p.cnt;
            
            for(String word : words){
                
                if(m.containsKey(word))
                    continue;
                                
                if(isValid(p.word,word)){
                    q.add(new Pair(word,p.cnt+1));
                    m.put(word,true);
                }
            }
        }
        return 0;
    }
    
    // 바꾸는게 가능하냐 
    private boolean isValid(String begin, String word){
                int cnt=0;
                if(begin.length()!=word.length())
                    return false;
                for(int i=0;i<begin.length();i++){
                    if(word.charAt(i)!=begin.charAt(i)){
                        cnt++;
                    }
                }
            return cnt==1?true:false;
        }    
    
}

class Pair{
    
    String word;
    int cnt;
    
    Pair(String word,int cnt){
        this.word=word;
        this.cnt=cnt;
    }
    
}