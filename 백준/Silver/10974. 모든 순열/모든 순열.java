import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.sort;
import static java.util.Comparator.reverseOrder;

public class Main {

    static int n;
    static boolean []visit = new boolean[10];

    public static void permu(int depth,int [] v){

        if(depth==n){
            for(int i=0;i<n;i++)
                System.out.print(v[i]+" ");
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            if(visit[i]==false){
                visit[i]=true;
                v[depth]=i;
                permu(depth+1,v);
                visit[i]=false;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n=sc.nextInt();

        int [] v= new int[10];
        permu(0,v);

    }
}