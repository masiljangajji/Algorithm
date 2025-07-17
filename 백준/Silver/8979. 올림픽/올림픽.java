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


        int cnt = 1;
        Rank currentRank = ranks[0];

        for (int i = 1; i < n; i++) {

            if (i == k) {
                break;
            }

            // k 번째 국가의 등수
            if (currentRank.gotTotalMedalCount() != ranks[i].gotTotalMedalCount()) { // 등수 변화 있어야 함
                cnt++;
            }

            currentRank = ranks[i];
            // 여기는 공동 등수임
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

    public int gotTotalMedalCount() {
        return gold + silver + bronze;
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
}