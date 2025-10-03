class Solution {
    public boolean solution(String s) {
        
        int len = s.length();
        
        for(int i=0;i<len;i++){
            if(Character.isAlphabetic(s.charAt(i))){
                return false;
            }
        }
        return 4==len||len==6;
    }
}