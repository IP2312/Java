import java.util.Scanner;

public class MineSweeperV1 {
    public static void main(String[] args) {
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
        int valueOfCoordinate;
        do {
            System.out.println("   A  B  C  D  E  F  G  H  I  J");
            for (int y = 0; y < map.length; y++) {
                System.out.print(y + " ");
                for (int x = 0; x < map[0].length; x++) {
                    if (map[y][x] > 0) {
                        System.out.print("[-]");
                    } else {
                        System.out.print("[ ]");
                    }
                    if (map[y][x] == 0) {
                        mineCount++;
                    }
                }
                System.out.println();
            }
            System.out.println("Du hasts x% des verminten Gebiets auf Minen gecheckt");
            System.out.println(String.format("Es bleiben noch %d Minen versteckt.", mineCount));
            System.out.println("Wo willst du nach Minen suchen?");
            coordinates = sc.nextLine();
            System.out.println(coordinates);
            char[] array = coordinates.toCharArray();

            char xCoordinate = array[0];
            int xvalue = (int) xCoordinate - 'A';
            System.out.println(xvalue);


            char yCoordinate = array[1];
            int yvalue = (int) yCoordinate - '0';
            System.out.println(yvalue);


            valueOfCoordinate = map[yvalue][xvalue];
            System.out.println(valueOfCoordinate);
            if (valueOfCoordinate != 0) {
                map[yvalue][xvalue] = map[yvalue][xvalue] * -1;
            }

        } while (valueOfCoordinate != 0);

    }
}
