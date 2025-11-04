import java.util.*;

class Solution {
    public int solution(String skill, String[] skillTrees) {
        
        Queue<Character> q = new LinkedList<>();
        for(char ch : skill.toCharArray()){
            q.add(ch);
        }
        
        int answer = 0;
        
        for(String s: skillTrees){
            Queue<Character> target = new LinkedList<>(q);
            answer+=check(target,s);
        }
        
        return answer;
    }
    
    private int check(Queue<Character>q,String skillTree){
        
        for(char ch:skillTree.toCharArray()){
            if(q.contains(ch)){
                if(q.peek()!=ch)
                    return 0;
                q.poll();
            }
        }
        return 1;
    }
    
}