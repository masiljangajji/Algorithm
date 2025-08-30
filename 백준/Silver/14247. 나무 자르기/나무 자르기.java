import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = sc.nextInt();

        List<Tuple> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Tuple(sc.nextInt(), i));
        }

        for (int i = 0; i < n; i++) {
            list.get(i).setHeight(sc.nextInt());
        }

        list.sort(Comparator.comparingInt(l -> l.growth));

        long sum = 0;

        for (int i = 0; i < list.size(); i++) {
            Tuple tuple = list.get(i);
            sum += tuple.height + tuple.growth * i;

        }

        System.out.println(sum);

    }

}

class Tuple {

    int height;
    int growth;
    int index;

    public Tuple(int height, int index) {
        this.height = height;
        this.index = index;
    }

    public void setHeight(int growth) {
        this.growth = growth;
    }

}