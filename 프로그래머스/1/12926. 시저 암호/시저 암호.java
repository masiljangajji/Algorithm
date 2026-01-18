class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            sb.append(encrypt(ch,n));
        }
        
        return sb.toString();
    }
    
    private char encrypt(char ch,int n){
            
        char flag;
        char reset;
        
        if(!Character.isAlphabetic(ch)){
            return ch;
        }
        else if('a'<=ch && ch<='z'){
            flag='z';
            reset='a';
        }else{
            flag='Z';
            reset='A';
        }
        
        for(int i=0;i<n;i++){
            if(ch==flag){
                ch=reset;
                continue;
            }
            ch++;   
        }
        return ch;
    }
    
}