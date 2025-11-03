import java.util.*;
class Solution {
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
  
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0;i<nodes.length;i++){
            nodes[i] = new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes,(v1,v2)->v2.y-v1.y);
        Node root = buildTree(nodes);
        
        List<Integer>pre = new ArrayList<>();
        List<Integer>post = new ArrayList<>();
        preOrder(root,pre);
        postOrder(root,post);
        
        answer[0]= pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1]= post.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    private void preOrder(Node root,List<Integer>list){
        
        if(root==null)
            return;
        
        list.add(root.value);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
    
    private void postOrder(Node root,List<Integer>list){
        
        if(root==null)
            return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.value);
    }
    
    
    private Node buildTree(Node[] nodes){
        Node root = nodes[0];
        
        for(int i=1;i<nodes.length;i++){
            insert(root,nodes[i]);
        }
        
        return root;
    }
    
    private void insert(Node root,Node node){
        
        if(node.x<root.x){
            // 왼쪽 서브 트리
            if(root.left==null)
                root.left=node;
            else
                insert(root.left,node);
        }else{
            // 오른쪽 서브 트리 
            if(root.right==null)
                root.right=node;
            else
                insert(root.right,node);
        }
        
    }
}
    
class Node{
    
    int y;
    int x;
    int value;
    Node left;
    Node right;
    
    public Node(int value,int x,int y){
        this.value=value;
        this.y=y;
        this.x=x;
    }
    
}