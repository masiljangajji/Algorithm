class Solution {
    
    public static class Pair implements Comparable<Pair>{

        int start , end;

        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.start==pair.start){
                return this.end-pair.end;
            }
            return this.start-pair.start;
        }
    }
    
    
    public int solution(String[][] book_time) {
        
        String [] str= new String[book_time.length];

        for(int i=0;i<book_time.length;i++){
            String a="";
            for(int j=0;j<book_time[i].length;j++){
                a+=book_time[i][j];
            }
            str[i]=a;
        }

        int []go = new int[100000];
        int Max=0;

        for(int i=0;i<book_time.length;i++) {

            int startH= Integer.parseInt(str[i].substring(0,2));
            int startM = Integer.parseInt(str[i].substring(3,5));

            int endH =Integer.parseInt(str[i].substring(5,7));
            int endM= Integer.parseInt(str[i].substring(8,10));

            int start= startH*3600+startM*60;
            int end= endH*3600+endM*60;

            for(int j=start;j<end+600;j++){
                go[j]++;
                Max= Math.max(go[j],Max);
            }

        }
        
        return Max;    
    }
}