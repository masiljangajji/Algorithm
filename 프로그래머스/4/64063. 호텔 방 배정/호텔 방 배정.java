import java.util.*;
class Solution {
    
    private Map<Long,Node> m = new HashMap<>();
    
    public long[] solution(long k, long[] roomNumber) {
        
        List<Long>list= new ArrayList<>();
        
        for(long room : roomNumber){
            
            if(m.containsKey(room)){
                room = m.get(room).max()+1;
            }
            
            Node node = new Node(room);
            m.put(room,node);
            
            if(m.containsKey(room-1)){
                node.merge(m.get(room-1));
            }
            
            if(m.containsKey(room+1)){
                node.merge(m.get(room+1));
            }
            
            list.add(room);
        }
        
        return list.stream().mapToLong(Long::longValue).toArray();
    }
    
}

class Node{
    
    int depth=1;
    Node parent = null;
    long max;
    
    public Node(long value){
        max = value;
    }

    boolean isConnect(Node o){
        return root() == o.root();
    }
    
    long max(){
        return root().max;
    }
    
    void merge(Node o){
        if(isConnect(o))
            return;
        
        Node root1 = root();
        Node root2 = o.root();
        
        if(root1.depth>root2.depth)
            root2.parent=root1;
        else if(root1.depth<root2.depth)
            root1.parent=root2;
        else{
            root1.depth+=1;
            root2.parent=root1;
        }
        
        root1.max = root2.max = Math.max(root1.max,root2.max);
    }
    
    Node root(){
        if(parent==null)
            return this;
        return parent.root();
    }
    
    
}