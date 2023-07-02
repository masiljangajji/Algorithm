import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

public class Main {

    public static class Pair implements Comparable<Pair>{

        int first;
        String second;

        Pair(int first,String second){
            this.first=first;
            this.second=second;
        }

        @Override
        public int compareTo(Pair pair) {

            return first-pair.first;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Pair>arr= new ArrayList<>();

        int n=sc.nextInt();

        int num;
        String str;

        for(int i=0;i<n;i++){
            num=sc.nextInt();
            str=sc.nextLine();
            arr.add(new Pair(num,str));
        }

        Collections.sort(arr);

        for(Pair pair:arr)
            System.out.println(pair.first+pair.second);



    }
}