import java.util.*;

class Solution {
    
     static boolean[] visit = new boolean[204];
    static List<Integer>[]v= new List[204];

    public static void dfs(int here){

        visit[here]=true; // 방문표시

        for(int i=0;i<v[here].size();i++){
            if(visit[v[here].get(i)]==false) {
                dfs(v[here].get(i));
            }
        }
        return;
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Arrays.fill(visit,false);
        
        for(int i=0;i<n;i++)
            v[i]= new ArrayList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&computers[i][j]==1){
                    v[i].add(j);
                }
            }
        }
        
        int cnt=0;

        for(int i=0;i<n;i++){
            if(v[i].size()==0){
                cnt++;
            }
            else if(visit[i]==false){
                cnt++;
                dfs(i);
            }
        }
        
        
        return cnt;
    }
}