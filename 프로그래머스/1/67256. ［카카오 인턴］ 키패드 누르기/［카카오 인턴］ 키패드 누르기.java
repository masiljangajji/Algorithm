import java.util.*;
class Solution {

    Map<Integer,Pair> map = new HashMap<>();
    
    public String solution(int[] numbers, String hand) {
        
        // 1 4 7 왼손 
        // 3 6 9 오른손
        
        // 1부터 시작해서 측정
        Pair left = new Pair(4,1);
        Pair right = new Pair(4,3);
        
        buildMap();

        StringBuilder sb = new StringBuilder();
        
        for(int n : numbers){
            
            Pair target = map.get(n);
            
            if(n==1||n==4||n==7){
                sb.append("L");
                left.move(target);
                continue;
            }
            
            if(n==3||n==6||n==9){
                sb.append("R");
                right.move(target);
                continue;
            }
            
            int leftLength = left.getLength(target);
            int rightLength = right.getLength(target);
            
            if(leftLength<rightLength){
                sb.append("L");
                left.move(target);
            }else if(rightLength<leftLength){
                sb.append("R");
                right.move(target);
            }else{
                if(hand.equals("left")){
                    sb.append("L");
                    left.move(target);
                }else{
                    sb.append("R");
                    right.move(target);
                }
            }
        }
        
        return sb.toString();
    }
    
    void buildMap(){
        map.put(1,new Pair(1,1));
        map.put(2,new Pair(1,2));
        map.put(3,new Pair(1,3));
        map.put(4,new Pair(2,1));
        map.put(5,new Pair(2,2));
        map.put(6,new Pair(2,3));
        map.put(7,new Pair(3,1));
        map.put(8,new Pair(3,2));
        map.put(9,new Pair(3,3));
        map.put(0,new Pair(4,2));
    }
    
}

class Pair{
    
    int y;
    int x;
    Pair(int y,int x){
        this.y=y;
        this.x=x;
    }
    
    void move(Pair p){
        this.y=p.y;
        this.x=p.x;
    }
    
    int getLength(Pair p){
        return Math.abs(this.y-p.y)+Math.abs(this.x-p.x);
    }
    
}