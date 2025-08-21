import java.beans.Introspector;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {

        // 처음 입장한 플레이어 레벨 기준 +-10 까지 입장 가능
        // 정원이 모두 찰 때까지 대기
        // 이때 입장 가능한 방이 여러개라면 먼저 생성된 방에 입장

        // 정원 모두 차면 시작

        int p, n, l, m;

        Scanner sc = new Scanner(System.in);

        int playerSize = sc.nextInt();
        int roomSize = sc.nextInt();

        List<Game> list = new ArrayList<>();

        for (int i = 0; i < playerSize; i++) {

            int level = sc.nextInt();
            String name = sc.next();

            if (list.isEmpty()) {
                Game game = new Game(level);
                game.players.add(new Player(level, name));
                list.add(game);
                continue;
            }

            boolean flag = true;

            for (int j = 0; j < list.size(); j++) {

                Game game = list.get(j);

                if (game.players.size() == roomSize)
                    continue;

                if (game.level - 10 <= level && level <= game.level + 10) {
                    game.players.add(new Player(level, name));

//                    System.out.println("두가자!!");
//                    game.prt();
                    flag = false;
                    break;
                }

            }

            if (flag) {
                // 새로운 방 만들기

                Game game = new Game(level);
                game.players.add(new Player(level, name));
                list.add(game);
            }
            // 매칭 가능한 방이 있는지? 확인 -> 레벨 범위로 확인


            // 없으면 -> 만들기
            // 있으면 -> 먼저 만든 방에 들어감


        }

        for (int i = 0; i < list.size(); i++) {
            Game game = list.get(i);
            if (game.players.size() == roomSize) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            game.prt();
        }

    }
}

class Game {

    int level;

    List<Player> players = new ArrayList<>();

    Game(int level) {
        this.level = level;
    }

    void prt() {


        List<Player> list = players
                .stream()
                .sorted(Comparator.comparing(p -> p.name))
                .collect(Collectors.toList());


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).playerLevel + " " + list.get(i).name);
        }
    }

}

class Player {

    int playerLevel;

    String name;

    Player(int playerLevel, String name) {
        this.playerLevel = playerLevel;
        this.name = name;
    }

}


