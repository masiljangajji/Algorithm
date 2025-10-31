import java.util.*;
import java.util.stream.*;
class Solution {
        
    private static final List<Pair>list= new ArrayList<>();
    
    private static int MAX = 0;
    
    public String[] solution(String[] orders, int[] course) {

        for(int length : course){
            combis(orders,length);
        }
        
        
        list.sort((p1,p2)->p1.key.compareTo(p2.key));
        
        String []answer = new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).key;
        }
        
        return answer;
    }
    
    private void combis(String orders[],int length){
        
        Map<String,Pair>m = new HashMap<>();
        MAX = 0;
        
        for(String order : orders){
            if(order.length()<length)
                continue;
            combi(m,order,length,new StringBuilder(),-1);
        }
        
        list.addAll(m.values()
            .stream()
            .filter(p->p.count==MAX&&p.count>=2)
            .sorted((p1,p2)->{
                return p1.key.compareTo(p2.key);
            })
            .collect(Collectors.toList())
                    );
        
    }
    
    private void combi(Map<String,Pair>m,String order,int length,StringBuilder sb,int depth){
        
        if(length==sb.length()){
            String str = sb
                .toString()
                .chars()
                .boxed()
                .sorted((v1,v2)->v1-v2)
                .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
            ).toString();
                        
            if(m.containsKey(str)){
                Pair p = m.get(str);
                p.add();
                MAX=Math.max(MAX,p.count);
            }else{
                m.put(str,new Pair(str,1));
                MAX=Math.max(MAX,1);
            }
            return;
        }        
        
        for(int i = depth+1;i<order.length();i++){
            sb.append(order.charAt(i));
            combi(m,order,length,sb,i);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}

class Pair{
    
    String key;
    int count;
    
    public Pair(String key,int count){
        this.key=key;
        this.count=count;
    }
    
    public void add(){
        this.count++;
    }
    
}