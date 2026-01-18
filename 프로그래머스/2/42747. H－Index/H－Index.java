import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // h번 이상 인용된게 h편 
        // 나머지가 H번 이하 인용 
        // n-h 는 h보다 작아야 함 
        
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i=citations[n-1];i>=0;i--){
            if(check(citations,i))
                return i;
        }
        return 0;
    }
    
    private boolean check(int[]arr,int h){
        
        int cnt=0;
        int len = arr.length;
        
        for(int i=0;i<len;i++){
            if(arr[i]>=h){
                // 0 1 3 5 6 
                // len-i; // h번 이상 인용
                // i+1 // h번 이하 인용 
                return len-i>=h&&i<=h;
            }
        }
        return false;
    }
}