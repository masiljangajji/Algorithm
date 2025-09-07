import java.util.*;

class Solution {
    
    
    public static int made =0;
    public static int total =0;
    public static int donaut=0;
    public static int bar=0;
    public static int eight=0;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer,Node> m = new HashMap<>();
        
        for(int i=0;i<edges.length;i++){
     
            int n = edges[i][0];       
            int v = edges[i][1];
            
            Node node = m.computeIfAbsent(n,k-> new Node(n));
            node.addOut(v);
            
            Node node2 = m.computeIfAbsent(v,k-> new Node(v));
            node2.addIn(n);
        }
        
        

        
        // 막대는 들어오는게1 , 나가는게 0
        // 8자모양 은 들어오는게2 , 나가는게 2
        // 도넛은 순회를 함 
        // 생성된 것은 들어오는게 없고, 나가는게 2
        
        find(m);
        remove(m);
        
        for(int k: m.keySet()){
                    
            Node node = m.get(k);

            if(node.in.size()==2&&node.out.size()==2){
                eight++;
            }
            
            if((node.in.size()==1&&node.out.size()==0)){
                bar++;
            }
            
        }
        
        donaut = total-bar-eight;
        
        answer[0] = made;
        answer[1]= donaut;
        answer[2] = bar;
        answer[3] = eight;
        
        
        return answer;
    }
    
    
    public void find(Map<Integer,Node>m){
        for(int k: m.keySet()){
            
            Node node = m.get(k);
            
            if(node.in.size()==0&&node.out.size()>=2){ // 만들어진 정점
                made = k;
                total = node.out.size();     
                m.remove(made);
                return;
            }
        }
        
        
    }
    
    public void remove(Map<Integer,Node>m){
        
        for(int k: m.keySet()){
                    
            Node node = m.get(k);
              
            List<Integer> list = node.in;
            
            for(int i=0; i<node.in.size();i++){
                if(node.in.get(i)==made){
                    
                    if(node.in.size()==1&&node.out.size()==0){
                        bar++;
                    }
                    node.in.remove(i);
                    break;
                }
            }
            
        }
    }
    

}

class Node{
    
    public List<Integer> in= new ArrayList<>();
    public List<Integer> out = new ArrayList<>();
    public int index;
    
    public Node(int index){
        this.index = index;
    }
    
    public void addIn(int n){
        in.add(n);
    }
    
    public void addOut(int n){
        out.add(n);
    }
    
}