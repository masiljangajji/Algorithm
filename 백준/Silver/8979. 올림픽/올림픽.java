import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 금메달 수가 더 많은 나라
        // 은메달 수가 더 많은 나라
        // 동메달 수가 더 많은 나라

        //  국가는 1부터 N 사이의 정수로 표현

        /**
         *
         * 한 국가의 등수는 (자신보다 더 잘한 나라 수) +1
         * 만약 메달 수가 같으면 공동 순위를 가진다.
         *
         * 첫 줄은 국가 수, 등수를 알고 싶은 국가
         *
         */

        int n, k;

        n = sc.nextInt();
        k = sc.nextInt();

        Rank[] ranks = new Rank[n];

        for (int i = 0; i < n; i++) {
            ranks[i] = new Rank(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }


        Arrays.sort(ranks);

//        for (Rank r : ranks) {
//            System.out.println(r);
//        }

        int cnt = 1;
        Rank currentRank = ranks[0];

        if (currentRank.countryNumber == k) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < n; i++) {

            if (!currentRank.hasSameMedals(ranks[i])) {
                cnt++; // 등수 업
            }

            currentRank = ranks[i];

            if (k == ranks[i].countryNumber) {
                break;
            }

        }

        System.out.println(cnt);


    }
}

class Rank implements Comparable<Rank> {

    int countryNumber;
    int gold;
    int silver;
    int bronze;

    public Rank(int countryNumber, int gold, int silver, int bronze) {
        this.countryNumber = countryNumber;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public boolean hasSameMedals(Rank other) {
        return this.gold == other.gold &&
                this.silver == other.silver &&
                this.bronze == other.bronze;
    }

    @Override
    public int compareTo(Rank o) {

        if (o.gold == this.gold) {
            if (o.silver == this.silver) {
                if (o.bronze == this.bronze) {
                    return 0;
                }
                return o.bronze - this.bronze;
            }
            return o.silver - this.silver;
        }
        return o.gold - this.gold;


    }

    @Override
    public String toString() {
        return countryNumber + "\t" + gold + "\t" + silver + "\t" + bronze;
    }

}