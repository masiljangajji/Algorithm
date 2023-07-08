import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.Arrays.sort;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int ans=0;
        
         Map<Character,Integer>m = new HashMap<>();
        
        
        for(int i=0;i<skill.length();i++){
            m.put(skill.charAt(i),i);
        }
        
        for(int i=0;i<skill_trees.length;i++){
            int cnt=0;
            boolean check = true;
            for(int j=0;j<skill_trees[i].length();j++){
                if(m.get(skill_trees[i].charAt(j))==null){
                    continue;
                }
                else if(m.get(skill_trees[i].charAt(j))==cnt){
                    cnt++;
                }
                else{
                    check = false;
                    break;
                }
            }

            if(check==true)
                ans++;
        }
        
        return ans;
    }
}