import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MineSweeperV2 {
    public static void main(String[] args) {
        boolean gameOver = false;
        String coordinates;
        int valueOfCoordinate;
        int nrExplored = 0;
        int[][] map = new int[10][10];
        Scanner sc = new Scanner(System.in);


        int mineCount = populateMapandCountMines(map);

        do {
            displaymap(map);

            int notMined = 100 - mineCount;
            double percentexplored = (double) nrExplored / notMined * 100;


            if (!gameOver) {
                System.out.println(String.format("Du hasts %d/%d (%.2f%%) des verminten Gebiets auf Minen gecheckt", nrExplored, notMined, percentexplored));
                System.out.println(String.format("Es bleiben noch %d Minen versteckt.", mineCount));

                do {
                    System.out.println("Wo willst du nach Minen suchen?");
                    coordinates = sc.nextLine().toUpperCase();
                } while (!validateInput(coordinates));

                int xvalue = convertInput(coordinates)[0];
                int yvalue = convertInput(coordinates)[1];

                valueOfCoordinate = map[yvalue][xvalue];
                if (valueOfCoordinate == -4){
                    gameOver = true;
                    System.out.println("Game over!");
                    for (int y = 0; y < map.length; y++) {
                        for (int x = 0; x < map[0].length; x++) {
                            if (map[x][y] == -4){
                                map[x][y] *= -1;
                            }
                        }
                    }
                    displaymap(map);
                }
                else if(valueOfCoordinate < 0) {
                    nrExplored++;
                    for (int i = valueOfCoordinate +1; i < -valueOfCoordinate; i++) {
                        for (int j = valueOfCoordinate +1; j < -valueOfCoordinate; j++) {
                            if (yvalue + i >= 0 && xvalue + j >= 0 && yvalue + i < 10 && xvalue + j < 10) {
                                map[yvalue + i][xvalue + j] = Math.abs(map[yvalue + i][xvalue + j]);
                            }
                        }

                    }
                }
            }

        } while (!gameOver);
    }

    static int populateMapandCountMines(int[][]map){
        Random r = new Random();
        int mines = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int cellValue = -r.nextInt(4) - 1;
                map[j][i] = cellValue;
                if (cellValue == -4) {
                    mines++;
                }
            }

        }
        return mines;
    }

    static void displaymap(int[][]map){
        System.out.println("   A  B  C  D  E  F  G  H  I  J");
        for (int y = 0; y < map.length; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] < 0) {
                    System.out.print("[ ]");
                } else if (map[y][x] == 4) {
                    System.out.print("[*]");
                } else {
                    System.out.print("[-]");
                }
            }
            System.out.println();
        }
    }

    static boolean validateInput(String input) {
        return Pattern.matches("^[A-J][0-9]$", input);
    }

    static int[] convertInput(String coordinates){
        char[] array = coordinates.toCharArray();
        int[] xy = new int[2];

        char xCoordinate = array[0];
        xy[0] = (int) xCoordinate - 'A';

        char yCoordinate = array[1];
        xy[1] = (int) yCoordinate - '0';
        return xy;
    }

}

