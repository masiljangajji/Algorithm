class Solution
{
    public int solution(String s)
    {
        
        int Max=1;
        char[] chr = s.toCharArray();
        
        // 가장 긴 문자열부터 팰린드롬 검사
        for (int leng = 2; leng <= s.length(); leng++) {
            
            // 시작 인덱스
            for (int start = 0; start + leng <= s.length(); start++) {
                boolean chk = true;
                
                // 처음부터 문자열 길이의 반틈만큼 문자가 같은지 비교
                for (int i = 0; i < leng/2; i++) {
                    if (chr[start + i] != chr[start + leng  - i - 1]) {
                        chk = false;
                        break;
                    }
                }
                
                if (chk) {
                    if(Max<leng)
                        Max=leng;
                }
            }
        }
        
        return Max;
    }
}