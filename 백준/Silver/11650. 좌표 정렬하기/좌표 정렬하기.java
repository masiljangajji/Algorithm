import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static class Pair implements Comparable<Pair>{

        int first,second;

        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }

        @Override
        public int compareTo(Pair pair) {

            if(first==pair.first){
                return second-pair.second;
            }
            return first-pair.first;

        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n= Integer.parseInt(bf.readLine());

        List<Pair>arr= new ArrayList<>();

        for(int i=0;i<n;i++){
            int a,b;
            StringTokenizer st = new StringTokenizer(bf.readLine());

            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            arr.add(new Pair(a,b));
        }

        Collections.sort(arr);

        for(int i=0;i<arr.size();i++){
            sb.append(arr.get(i).first+" ").append(arr.get(i).second).append("\n");
        }

        System.out.println(sb);



    }
}