class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(Integer.toString(n,3));
        
        sb.reverse();
                
        String s = sb.toString();
        
        return Integer.parseInt(s,3);
    }
}