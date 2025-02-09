import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있음 
        // 영희가 가진 카드들에 모든 숫자들중 하나도 나눌 수 없음 
        
        // 영희가 가진 모든 숫자 나눌 수 있음
        // 철수가 가진 모든 숫자 나눌수 없음 
        
        Stack<Integer>st = new Stack<>();
        Stack<Integer>st2 = new Stack<>();
        
        st.push(arrayA[0]);
        st2.push(arrayB[0]);
        
        int cnt = 1;
        while(cnt<arrayA.length){
            
            int currnet = arrayA[cnt];
            int exist = st.pop();
            
            int gc = gcd(currnet,exist);
            st.push(gc);
            cnt++;
        }
        
        
        int cnt2 = 1;
        while(cnt2<arrayA.length){
            
            int currnet = arrayB[cnt2];
            int exist = st2.pop();
            
            int gc = gcd(currnet,exist);
            st2.push(gc);
            cnt2++;
        }
        
        
        int A = st.peek();
        int B = st2.peek();
        
        List<Integer>list = new ArrayList<>();
        for(int i=2;i<=A;i++){
            if(A%i==0){
                list.add(i);
            }
        }
        List<Integer>list2 = new ArrayList<>();
        for(int i=1;i<=B;i++){
            
        }
        
        if(A==1&&B>1){
            for(int num : arrayA){
                if(num%B==0){
                    return 0;
                }
            }
            return B;
        }else if(B==1&&A>1){
            for(int num: arrayB){
                if(num%A==0)
                    return 0;
            }
            return A;
        }else if(A>1&&B>1){
            boolean flagA = false;
            boolean flagB = false;
            for(int num:arrayA){
                if(num%B==0){
                    flagB = true;
                    break;
                }
            }
            
            for(int num:arrayB){
                if(num%A==0){
                    flagA = true;
                    break;
                }
            }
            
            if(flagA&&flagB){
                return 0;
            }
            else if(flagA){
                return B;
            }else if(flagB)
                return A;
            else{
                if(A>B)
                    return A;
                return B;
            }
            
        }else if(A==1&&B==1){
            return 0;
        }
        
        return answer;
    }
    
    public int gcd(int a,int b){
        
        if(a%b==0){
            return b;
        }
        
        return gcd(b,a%b);
    }
    
}