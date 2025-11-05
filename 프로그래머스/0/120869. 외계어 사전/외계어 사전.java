import java.util.*;
class Solution {
    
    private boolean []isVisited = new boolean[11];
    public int solution(String[] spell, String[] dic) {
        
        // spell 로 한번씩만 모두 
        Set<String>set = new HashSet<>();
        permutation(set,spell,new char[spell.length],0);
        
        for(String s: dic){
            if(set.contains(s))
                return 1;
        }
        
        return 2;
    }
    
    private void permutation(Set<String>set,String []spell,char []ch,int depth){

        if(depth==spell.length){
            String str = Arrays.toString(ch).replace(",","").replace(" ","");
            set.add(str.substring(1,str.length()-1));
            return;
        }
        
        for(int i=0;i<spell.length;i++){
            if(isVisited[i])
                continue;
            
            isVisited[i]= true;
            ch[depth] = spell[i].charAt(0);
            permutation(set,spell,ch,depth+1);
            isVisited[i]=false;
        }
              
    }
    
}