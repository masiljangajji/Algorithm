import java.util.*;
class Solution {
    
    private Map<String,Fee> cars = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
    
        for(String r:records){
            
            String [] parseString = r.split(" ");
            
            int time = stringToInt(parseString[0]);
            String carNumber = parseString[1];
            String flag = parseString[2];
            
            cars.putIfAbsent(carNumber,new Fee(carNumber));
         
            Fee fee = cars.get(carNumber);
            
            if(parseString[2].equals("IN")){
                fee.inAdd(time);
                continue;
            }
            
            fee.outAdd(time);
        }
        
        return cars.values()
            .stream()
            .sorted((v1,v2)->v1.id.compareTo(v2.id))
            .map(f->f.getTotalFee(fees))
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int stringToInt(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3));
        return (hour*60)+minute;
    }
    
}

class Fee{
    
    String id;
    
    Queue<Integer> in = new LinkedList<>();
    Queue<Integer> out = new LinkedList<>();
    
    Fee(String id){
        this.id=id;
    }
    
    void inAdd(int number){
        in.add(number);
    }
    
    void outAdd(int number){
        out.add(number);
    }
    
    int getTotalFee(int[]fees){
    
        int total = 0;
        
        while(!in.isEmpty()){
            int inTime = in.poll();
            int outTime = 1380+59;
            if(!out.isEmpty()){
                outTime = out.poll();
            }
            total +=(outTime-inTime);
        }
        
        if(total<=fees[0]){
            return fees[1];
        }
        
        int remain = total-fees[0];
        int cnt = remain/fees[2];
        if(remain%fees[2]>0){
            cnt++;
        }
        
        return fees[1]+(cnt*fees[3]);
    }
    
}