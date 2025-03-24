import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class ZahlenRatenV2 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        char answer;
        boolean myTurn = r.nextBoolean();
        ArrayList<Integer> tips = new ArrayList<>();
        ArrayList<Integer> possiblevalues = new ArrayList<>();

        do {
            int randomNr = r.nextInt(101);
            System.out.println("RandomNr: " + randomNr);
            for (int i = 0; i < 101; i++) {
                possiblevalues.add(i);
            }


            int tip;
            do {
                if (myTurn) {
                    System.out.println("Gib einen Tip ab (0-100).");
                    tip = sc.nextInt();
                } else {
                    //calculate tip of computer
                    if (possiblevalues.size() > 40) {
                        tip = possiblevalues.get(20);
                    } else {
                        tip = possiblevalues.get(possiblevalues.size() / 2);
                    }

                }
                System.out.println("Tip: " + tip);
                myTurn = !myTurn;


                int dif = Math.abs(randomNr - tip);
                if (tip == randomNr) {
                    System.out.println("Erraten");
                } else {
                    if (dif <= 3) {
                        possiblevalues.remove(Integer.valueOf(tip));
                        System.out.println("fast da (1-3 daneben)");
                        remove(1, 3, tip, possiblevalues);
                    } else if (dif <= 10) {
                        System.out.println("relativ nahe (4-10 daneben)");
                        remove(1, 3, tip, possiblevalues);
                    } else if (dif <= 20) {
                        System.out.println("Nicht ganz so weit weg (11-20) daneben");
                        remove(11, 20, tip, possiblevalues);
                    } else {
                        System.out.println("Weit weg (>20) daneben");
                        for (int i = possiblevalues.size() - 1; i >= 0; i--) {
                            int min = tip - 20;
                            int max = tip + 20;
                            if ((possiblevalues.get(i) >= min && possiblevalues.get(i) <= max)) {
                                possiblevalues.remove(i);
                            }
                        }
                    }
                    tips.add(tip);
                    System.out.println("Tips: " + tips);
                    System.out.println(possiblevalues);
                }
            } while (tip != randomNr);
            System.out.println("Möchtest du nochmal spielen(YES/NO)?");
            answer = sc.next().toUpperCase().charAt(0);
        } while (answer == 'Y');

    }

    static void remove(int min, int max, int tip, ArrayList<Integer> possibelevalues1) {
        for (int i = possibelevalues1.size() - 1; i >= 0; i--) {
            if (Math.abs(possibelevalues1.get(i) - tip) < min || Math.abs(possibelevalues1.get(i) - tip) > max) {
                possibelevalues1.remove(i);
            }
        }
    }
}
