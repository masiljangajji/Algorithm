import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        
        // 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들기 
        // 다리 여러번 건너도 도달가능하면 통행 가능 
        
        //1 <= n <= 100
        // 다리 만드는 비용이 가장 적은 것 부터 
        // 서로소 집합
        
        Arrays.sort(costs,(v1,v2)->v1[2]-v2[2]);
        
        Node[]nodes = new Node[n];
        for(int i=0;i<n;i++){
            nodes[i] = new Node();
        }
        
        int totalCost = 0;
        
        for(int[]cost : costs){
            Node node1 = nodes[cost[0]];
            Node node2 = nodes[cost[1]];
            
            if(node1.isConnect(node2))
                continue;
            node1.merge(node2);
            totalCost+=cost[2];
        }
        
        return totalCost;
    }
    
}

class Node{
    
    public Node parent = null;
    public int depth=1;
    
    public boolean isConnect(Node o){
        return root()==o.root();
    }
    
    public void merge(Node o){
        if(isConnect(o))
            return;
        
        Node root1 = root();
        Node root2 = o.root();
        
        if(root1.depth>root2.depth)
            root2.parent=root1;
        else if(root1.depth<root2.depth)
            root1.parent=root2;
        else{
            root2.parent=root1;
            root1.depth+=1;
        }
    }
    
    public Node root(){
        if(parent==null)
            return this;
        return parent.root();
    }
    
}