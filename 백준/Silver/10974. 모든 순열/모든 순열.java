import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Comparator.reverseOrder;

public class Main {

    static int n;
    static boolean []visit = new boolean[10];

    public static void permu(List<Integer>v){

        if(v.size()==n){
            for(Integer a:v)
                System.out.print(a+" ");
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            if(visit[i]==false){
                visit[i]=true;
                v.add(i);
                permu(v);
                v.remove(v.size()-1);
                visit[i]=false;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n=sc.nextInt();

        List<Integer>v = new ArrayList<>();
        permu(v);

    }
}