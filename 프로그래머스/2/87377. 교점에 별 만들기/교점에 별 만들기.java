import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        List<Pair> list= new ArrayList<>();
        
        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++){
                Pair p = Pair.intersection(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
                
                if(p!=null){
                    list.add(p);
                }
            }
        }
        
        Pair maximum = Pair.getMax(list);
        Pair minimum = Pair.getMin(list);
        
        int width = (int)(maximum.x-minimum.x)+1;
        int height = (int)(maximum.y-minimum.y)+1;
        
        char [][]arr= new char[height][width];
        
        for(char[] row : arr){
            Arrays.fill(row,'.');            
        }

        for(Pair p : list){
            int nx = (int)(p.x - minimum.x);
            int ny = (int)(maximum.y-p.y);
            
            arr[ny][nx] = '*';
        }
        
        String[]answer = new String[arr.length];
        
        for(int i=0;i<arr.length;i++){
            answer[i]=new String(arr[i]);
        }
        
        return answer;
    }
}

class Pair{
    
    public final long x,y;
    
    public Pair(long x,long y){
        this.x= x;
        this.y= y;
    }
    
    public static Pair intersection(long a1,long b1,long c1,long a2,long b2,long c2){
    
        double x = (double)(b1*c2-b2*c1)/(a1*b2-a2*b1);
        double y = (double)(a2*c1-a1*c2)/(a1*b2-a2*b1);
        
        if(x%1!=0||y%1!=0)
            return null;
        
        return new Pair((long)x,(long)y);    
    }
    
    public static Pair getMax(List<Pair>pairs){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Pair p : pairs){
            if(x<p.x)
                x=p.x;

            if(y<p.y)
                y=p.y;        
        }
    
        return new Pair(x,y);
    }
    
    public static Pair getMin(List<Pair>pairs){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Pair p:pairs){
            if(x>p.x)
                x=p.x;

            if(y>p.y)
                y=p.y;            
        }
        

        
        return new Pair(x,y);
    }
       
}
