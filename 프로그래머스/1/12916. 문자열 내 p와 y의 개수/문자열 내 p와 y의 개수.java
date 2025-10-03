class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cp = 0;
        int cy = 0;
        
        s = s.toLowerCase();
        
        int num = s.length();
        s = s.replaceAll("p","");
        
        cp = num - s.length();
        
        num = s.length();
        
        s = s.replaceAll("y","");
        
        cy = num-s.length();

        return cp==cy;
    }
}