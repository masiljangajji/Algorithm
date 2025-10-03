class Solution {
    public int solution(String s) {
        
        
        StringBuilder sb = new StringBuilder();
        
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
        
            if(Character.isDigit(ch)){
                answer*=10;
                answer+=ch-'0';
                continue;
            }
            
            sb.append(ch);
                
            char number = getNumber(sb.toString());
            
            if(Character.isDigit(number)){
                answer*=10;
                answer+=number-'0';
                sb.setLength(0);
            }
        }
        
        return answer;
    }
    
    public char getNumber(String str){
        
        return switch(str){
            case "zero" -> '0';
            case "one" ->  '1';
            case "two" ->  '2';
            case "three" ->  '3';
            case "four" ->  '4';                
            case "five" ->  '5';
            case "six" ->  '6';
            case "seven" ->  '7';
            case "eight" ->  '8';
            case "nine" ->  '9';
            default -> 'a';
        };
        
    }
    
}