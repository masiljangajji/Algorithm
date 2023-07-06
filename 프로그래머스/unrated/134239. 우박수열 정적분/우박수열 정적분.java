import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.Arrays.sort;

class Solution {
    
    public static double go(int a,int b){

        // a가 이전것 b가 다음것

        double sum=0;

        if(a<b){
            sum+=(double)(b-a)/2;
            sum+=a;
        }
        else{
            sum+=(double)(a-b)/2;
            sum+=b;
        }

        return sum;
    }
    
    
    public double[] solution(int k, int[][] ranges) {
        
        
        List<Double>arr= new ArrayList<>();
       
        double res=0;
        int cnt=0;
        
        while(k>1){

            if(k%2==0){
                res+=go(k,k/2);
                k/=2;
            }
            else{
                res+=go(k,k*3+1);
                k=k*3+1;
            }
            cnt++;
            arr.add(res);
        }
        
         List<Double>answer = new ArrayList<>();

        for(int i=0;i<ranges.length;i++){
            int start=ranges[i][0];
            int end=ranges[i][1]+arr.size();


            if(start>end){
                answer.add(-1.0);
            }
            else if(start==end)
                answer.add(0.0);
            else if(start==0){
                double result = arr.get(end-1);
                String temp = String.format("%.1f", result);
                answer.add(Double.parseDouble(temp));
            }
            else {
                double result = arr.get(end-1) - arr.get(start-1);
                String temp = String.format("%.1f", result);
                answer.add(Double.parseDouble(temp));
            }

        }


        double []ans= answer.stream().mapToDouble(Double::doubleValue).toArray();
        
        return ans;
        
        
        
    }
}