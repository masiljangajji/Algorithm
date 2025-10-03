class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            sb.append(encrypt(s.charAt(i),n));
        }

        
        return sb.toString();
    }
    
    public char encrypt(char ch,int n){
        
        int num = ch+n;
        
        if(Character.isLowerCase(ch)){
            if(num>122){
                num%=123;
                num +='a';
            }
            return (char)num;
        }else if(Character.isUpperCase(ch)){
            if(num>90){
                num %=91;
                num+='A';
            }   
            return (char)num;
        }

        return ' ';
    }
    
}