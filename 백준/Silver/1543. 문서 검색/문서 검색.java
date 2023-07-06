import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        String str= bf.readLine();
        String str2=bf.readLine();

        int cnt=0;

        while(str.contains(str2)){

            int n= str.indexOf(str2);
            cnt++;
            str= str.substring(n+str2.length());
            //System.out.println(str);
        }

        System.out.println(cnt);

    }
}