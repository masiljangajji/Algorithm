import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.sort;

public class Main{

    public static void main(String[] args) throws IOException {

       BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

       int n= Integer.parseInt(bf.readLine());

       StringTokenizer st = new StringTokenizer(bf.readLine());
       StringBuilder sb = new StringBuilder();

        Map<Integer,Integer>m=new HashMap<>();

        List<Integer>v=new ArrayList<>();
        List<Integer>ans= new ArrayList<>();
       while(st.hasMoreTokens()) {
           int num = Integer.parseInt(st.nextToken());
           v.add(num); // 2 4 -10 4 -9
            m.put(num,1);
       }

       for(Integer a:m.keySet()){
           ans.add(a);
       }

       Collections.sort(ans);
       // 오름차순 -10 -9 2 4

        for(int i=0;i<ans.size();i++){
            m.put(ans.get(i),i); // 값 , idx
            // -10 -9 2 4
            // 0    1  2 3
        }

        for(int i=0;i<v.size();i++){
            sb.append(m.get(v.get(i))).append(" ");
        }
        System.out.println(sb);

    }
}