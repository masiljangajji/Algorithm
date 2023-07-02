import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Pair implements Comparable<Pair>{
        int first;
        int second;

        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.second==pair.second){
                return this.first-pair.first;
            }
            return this.second-pair.second;
        }
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Pair>arr= new ArrayList<>();

        int n=Integer.parseInt(bf.readLine());

        for(int i=0;i<n;i++){

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr.add(new Pair(a,b));

        }

        Collections.sort(arr);

        for(int i=0;i<n;i++){
            sb.append(arr.get(i).first).append(" ").append(arr.get(i).second).append("\n");
        }
        System.out.println(sb);



    }
}