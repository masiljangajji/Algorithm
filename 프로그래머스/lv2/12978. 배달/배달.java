import java.util.*;

class Solution {
    
    static boolean [][]visit = new boolean[51][51];
    static int [][]cost = new int[51][51];

    static List<Integer>[]arr= new List[51];

    static Map<Integer,Integer>m= new HashMap<>();

    public static class Pair{

        int dir ,sum;

        Pair(int dir ,int sum){
            this.dir=dir;
            this.sum=sum;
        }

    }
    
    public static void bfs(int k) {

        Queue<Pair>q= new LinkedList<>();

        q.add(new Pair(1,0));

        m.put(1,0);

        while(!q.isEmpty()){

            Pair a= q.poll();

            for(int i=0;i<arr[a.dir].size();i++){
                int temp =a.sum + cost[a.dir][arr[a.dir].get(i)];

                if(m.get(arr[a.dir].get(i))<=temp)
                    continue;
                if (temp <= k) {
                    q.add(new Pair(arr[a.dir].get(i),temp));
                    m.put(arr[a.dir].get(i),temp);
                }
            }

        }


        return;
    }
    
    
    public int solution(int N, int[][] road, int K) {
       
        for(int i=0;i<=50;i++){
            arr[i]= new ArrayList<>();
        }
        
       for(int i=0;i<road.length;i++) {

            if(!arr[road[i][0]].contains(road[i][1])) {
                arr[road[i][0]].add(road[i][1]);
                arr[road[i][1]].add(road[i][0]);
            }

            if (cost[road[i][0]][road[i][1]] != 0) {
                cost[road[i][0]][road[i][1]]=Math.min(cost[road[i][0]][road[i][1]],road[i][2]);
                cost[road[i][1]][road[i][0]]=Math.min(cost[road[i][1]][road[i][0]],road[i][2]);
            } else {
                cost[road[i][0]][road[i][1]] = road[i][2];
                cost[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        
        for(int i=2;i<=N;i++)
            m.put(i,123456789);
        
        bfs(K);
        
        int cnt=0;
        for(int i=1;i<=N;i++)
            if(m.get(i)!=123456789){
                cnt++;
            }
        
        return cnt;
    }
}