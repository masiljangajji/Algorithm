class Solution {
    public int[] solution(long n) {
        
        String number = String.valueOf(n);
        
        StringBuilder sb = new StringBuilder(number);
            
        sb.reverse();
        
        String reversedNumber = sb.toString();
        
        int[] answer = new int[reversedNumber.length()];
        
        for(int i=0;i<reversedNumber.length();i++){
            answer[i] = reversedNumber.charAt(i)-'0';
        }
        
        return answer;
    }
}