import java.util.*;

class Solution {
    
    static boolean []visit = new boolean[51];

    static int Min=123456789;
    
    
    public  boolean go(String str,String[] words,int idx){

        int cnt=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=words[idx].charAt(i))
                cnt++;
        }

        return (cnt==1)?true:false;

    }

    public  void dfs(String str,String target, String[]words,int cnt) {

        if(str.equals(target)) {
            Min=Math.min(Min,cnt);
        }

        for (int i = 0; i < words.length; i++) {

            if (visit[i] == true)
                continue;

            if (go(str, words,i) == true) {
                visit[i] = true;
                dfs(words[i],target,words, cnt+1);
                visit[i]=false;
            }
        }

        return;

    }
    
    
    public int solution(String begin, String target, String[] words) {
        
        
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(visit,false);
            if(go(begin,words,i)==true){
                visit[i]=true;
                dfs(words[i], target,words,1);
            }
            System.out.println(Min);
        }

    
        if(Min==123456789)
            return 0;
        else
            return Min;
        
    }
}