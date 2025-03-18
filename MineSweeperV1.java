public class MineSweeperV1 {
    public static void main(String[] args) {
        int [][] area = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},

        };
        for (int y = 0; y < area.length; y++) {
            for (int x = 0; x < area[0].length; x++) {
                System.out.print("[" + area[y][x] + "]");
            }
            System.out.println();

        }

    }
}
