import java.util.Scanner;
import java.util.Random;

public class MineSweeperV1 {
    public static void main(String[] args) {
        boolean gameOver = false;
        int mineCount = 0;
        String coordinates;
        int valueOfCoordinate = 1;
        int nrExplored = 0;
        int[][] map = new int[10][10];

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        //create map
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int mine = (r.nextInt(4))* -1;
                System.out.println(mine);
                map[j][i] = mine;
                if (mine == 0){
                    mineCount++;
                }
            }
            
        }


        //display map
        do {
            System.out.println("   A  B  C  D  E  F  G  H  I  J");
            for (int y = 0; y < map.length; y++) {
                System.out.print(y + " ");
                for (int x = 0; x < map[0].length; x++) {
                    if (map[y][x] > 0) {
                        System.out.print("[-]");
                    } else if (valueOfCoordinate == 0 && map[y][x] == 0) {
                        System.out.print("[*]");
                        gameOver = true;
                    } else {
                        System.out.print("[ ]");
                    }
                }
                System.out.println();
            }
            int notMined = 100 - mineCount;
            double percentexplored = (double)nrExplored/notMined * 100;



            if (!gameOver) {
                System.out.println(String.format("Du hasts %d/%d (%.2f%%) des verminten Gebiets auf Minen gecheckt",nrExplored,notMined, percentexplored));
                System.out.println(String.format("Es bleiben noch %d Minen versteckt.", mineCount));
                System.out.println("Wo willst du nach Minen suchen?");
                coordinates = sc.nextLine();
                nrExplored++;
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
