import java.util.Scanner;

public class MineSweeperV1 {
    public static void main(String[] args) {
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        int[][] map = {
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
                {0, -1, -2, -3, 0, -1, -2, -3, 0, -1},
        };


        String coordinates;
        int mineCount = 0;
        int valueOfCoordinate = 1;
        boolean minesCounted = false;
        int nrExplored = 0;
        do {
            System.out.println("   A  B  C  D  E  F  G  H  I  J");
            for (int y = 0; y < map.length; y++) {
                System.out.print(y + " ");
                for (int x = 0; x < map[0].length; x++) {
                    if (map[y][x] > 0) {
                        System.out.print("[-]");
                        nrExplored++;
                    } else if (valueOfCoordinate == 0 && map[y][x] == 0) {
                        System.out.print("[*]");
                        gameOver = true;
                    } else {
                        System.out.print("[ ]");
                    }
                    if (map[y][x] == 0 && !minesCounted) {
                        mineCount++;
                    }
                }
                System.out.println();
            }
            minesCounted = true;
            int notMined = 100 - mineCount;
            double percentexplored = (double)nrExplored/notMined;



            if (!gameOver) {
                System.out.println(String.format("Du hasts %d/%d (%.2f%%) des verminten Gebiets auf Minen gecheckt",nrExplored,notMined, percentexplored));
                System.out.println(String.format("Es bleiben noch %d Minen versteckt.", mineCount));
                System.out.println("Wo willst du nach Minen suchen?");
                coordinates = sc.nextLine();
                char[] array = coordinates.toCharArray();

                char xCoordinate = array[0];
                int xvalue = (int) xCoordinate - 'A';


                char yCoordinate = array[1];
                int yvalue = (int) yCoordinate - '0';


                valueOfCoordinate = map[yvalue][xvalue];
                if (valueOfCoordinate != 0) {
                    map[yvalue][xvalue] = map[yvalue][xvalue] * -1;
                }
            }


        } while (!gameOver);

    }
}
