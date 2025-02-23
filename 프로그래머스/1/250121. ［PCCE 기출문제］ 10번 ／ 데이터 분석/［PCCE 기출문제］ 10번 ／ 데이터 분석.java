import java.util.*;
import java.lang.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Data> list = new ArrayList<>();
        
        Map<String,Integer> m = new HashMap<>();
        
        m.put("code",0);
        m.put("date",1);
        m.put("maximum",2);
        m.put("remain",3);
        
    
        int idx = m.get(ext);
        int sort = m.get(sort_by);
        for(int i=0;i<data.length;i++){
            if(data[i][idx]<=val_ext){
                Data data_ = new Data(data[i][0],data[i][1],data[i][2],data[i][3]);                   list.add(data_);
            }        
        }
        
        Comparator<Data>comparator = null;
        
        switch(sort){
            case 0 : comparator = Comparator.comparingInt(data_ -> data_.code);
                break;
            case 1 : comparator = Comparator.comparingInt(data_ -> data_.date);
                break;
            case 2 : comparator = Comparator.comparingInt(data_ -> data_.maximum);
                break;
            case 3 : comparator = Comparator.comparingInt(data_ -> data_.remain);
                break;
        }
        
        list.sort(comparator);
        
        
        int [][]answer= new int[list.size()][4];
        
        for(int i=0;i<list.size();i++){
            
            Data data_ = list.get(i);
            
            answer[i][0]= data_.code;
            answer[i][1]= data_.date;
            answer[i][2]= data_.maximum;
            answer[i][3]= data_.remain;
        }
        
        return answer;
    }
}

class Data {
    
    public Data(int code,int date,int maximum,int remain){
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain=remain;
    }
    
    int code;
    int date;
    int maximum;
    int remain;
    
}