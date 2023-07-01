import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

class Solution {
    
     public static int check(String str){

        Stack<Character> stk=new Stack<Character>();

        for(int i=0;i<str.length();i++){

            if(stk.empty()){
                stk.push(str.charAt(i));
            }
            else if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='('){
                stk.push(str.charAt(i));
            }
            else if(str.charAt(i)=='}'){
                if(stk.peek()=='{')
                    stk.pop();
                else
                    return 0;
            }
            else if(str.charAt(i)==']'){
                if(stk.peek()=='[')
                    stk.pop();
                else
                    return 0;
            }
            else if(str.charAt(i)==')'){
                if(stk.peek()=='(')
                    stk.pop();
                else
                    return 0;
            }

        }

        if(stk.empty())
            return 1;

        return 0;
    }
    
    
    public int solution(String s) {
        

     String str=s;
    int answer=0;

        answer+=check(str);

        for(int i=0;i<str.length()-1;i++) {

            char end=str.charAt(0);

            str=str.substring(1,str.length())+end;
            answer+=check(str);
        }

        
        return answer;
    }
}