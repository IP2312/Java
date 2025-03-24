import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class ZahlenRatenV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char answer;
        ArrayList<Integer> possiblevalues = new ArrayList();

        for (int i = 0; i < 101; i++) {
            possiblevalues.add(i);
        }


        do {
            int randomNr = r.nextInt(101);
            System.out.println(randomNr);
            //int tries = 0;
            int tip;

            ArrayList<Integer> tips = new ArrayList<>();
            do {
                System.out.println("Gib einen Tip ab (0-100).");
                tip = sc.nextInt();
                int dif = Math.abs(randomNr - tip);

                if (tip == randomNr) {
                    System.out.println("Erraten");
                } else {
                    if (dif <= 3) {
                        System.out.println("fast da (1-3 daneben)");
                    } else if (dif <= 10) {
                        System.out.println("relativ nahe (4-10 daneben)");
                    } else if (dif <= 20) {
                        System.out.println("Nicht ganz so weit weg (11-20) daneben");
                    } else {
                        System.out.println("Weit weg (>20) daneben");
                    }
                    tips.add(tip);
                    System.out.println("Tips: " + tips);
                }
            } while (tip != randomNr);
            System.out.println("Möchtest du nochmal spielen(YES/NO)?");
            answer = sc.next().toUpperCase().charAt(0);
        } while (answer == 'Y');

    }
}
