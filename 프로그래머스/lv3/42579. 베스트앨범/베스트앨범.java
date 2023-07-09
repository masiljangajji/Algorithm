import java.util.*;

class Solution {
    
    public static class Pair implements Comparable<Pair>{

        int play;
        int idx;

        Pair(int play,int idx){
            this.play=play;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair a) {

            if(this.play==a.play){
                return this.idx-a.idx;
            }

            return a.play-this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
       
        
        Map<String,Integer>m= new HashMap<>();
        Map<String,Integer>order= new HashMap<>();
        Map<Integer,String>m2 = new TreeMap<>();
        
        int check=0;
        
        for(int i=0;i<genres.length;i++){
            m.put(genres[i],m.get(genres[i])==null?-plays[i]:m.get(genres[i])-plays[i]);
            if(order.get(genres[i])==null) {
                order.put(genres[i], check);
                check++;
            }
        }

        List<Pair>[]v= new List[order.size()];

        for(int i=0;i<v.length;i++)
            v[i]=new ArrayList<>();


        for(int i=0;i<genres.length;i++){
            v[order.get(genres[i])].add(new Pair(plays[i],i));
        }

        for(int i=0;i<v.length;i++)
            Collections.sort(v[i]);


        for(Map.Entry<String,Integer>a:m.entrySet()){
            m2.put(a.getValue(),a.getKey());
        }

        List<Integer>arr = new ArrayList<>();
        

        for(String a:m2.values()){

            if(v[order.get(a)].size()>=2){
                for(int i=0;i<2;i++){
                arr.add(v[order.get(a)].get(i).idx);
                }
            }
            else{
                arr.add(v[order.get(a)].get(0).idx);
            }
            
        }
        
        int [] ans = arr.stream().mapToInt(Integer::intValue).toArray();
        
        return ans;
    }
}