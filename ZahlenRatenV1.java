import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class ZahlenRatenV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int level;
        do {

            do {
                System.out.println("Welches Level möchtest du spielen? Lv:(1 2 3) 0 zum beenden");
                level = sc.nextInt();
            } while (level < 0 || level > 4);

            char answer;
            switch (level) {

                case 1:
                    do {
                        int randomNr = r.nextInt(101);
                        System.out.println(randomNr);
                        int tries = 0;
                        int tip;
                        do {
                            System.out.println("Gib einen Tip ab (0-100).");
                            tip = sc.nextInt();
                            tries++;
                            if (tip == randomNr) {
                                System.out.println("Erraten");
                            } else {
                                if (tip > randomNr) {
                                    System.out.println("Kleiner");
                                } else {
                                    System.out.println("Größer");
                                }
                                System.out.println(String.format("Noch %d Versuche", 9 - tries));
                            }
                        } while (tip != randomNr && tries < 9);
                        System.out.println("Möchtest du nochmal spielen(YES/NO)?");
                        answer = sc.next().toUpperCase().charAt(0);
                    } while (answer == 'Y');
                    break;

                case 2:
                    do {
                        int randomNr = r.nextInt(101);
                        System.out.println(randomNr);
                        int tries = 0;
                        int tip;

                        ArrayList<Integer> tips = new ArrayList<>();
                        do {
                            System.out.println("Gib einen Tip ab (0-100).");
                            tip = sc.nextInt();
                            if (tip == randomNr) {
                                System.out.println("Erraten");
                            } else {
                                if (Math.abs(randomNr - tip) <= 3) {
                                    System.out.println("fast da (1-3 daneben)");
                                } else if (Math.abs(randomNr - tip) <= 10) {
                                    System.out.println("relativ nahe (4-10 daneben)");
                                } else if (Math.abs(randomNr - tip) <= 20) {
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
                    break;

                case 3:
                    do {
                        int randomNr = r.nextInt(101);
                        System.out.println(randomNr);
                        int tip;
                        boolean myTurn = r.nextBoolean();
                        int higherthan = 100;
                        int lowerthan = 0;
                        ArrayList<Integer> tips = new ArrayList<>();
                        do {
                            if (myTurn) {
                                System.out.println("Gib einen Tip ab (0-100).");
                                tip = sc.nextInt();
                            } else {
                                //calculate tip of computer

                                tip = lowerthan + (higherthan - lowerthan)/2;
                                System.out.println("Tip des Computers: " + tip);
                            }
                            tips.add(tip);
                            if (tip == randomNr) {
                                System.out.println("Erraten");
                                if (myTurn){
                                    System.out.println("Gewonnen!");
                                }
                                else {
                                    System.out.println("Computer gewinnt!");
                                }
                            } else if (tip > randomNr) {
                                System.out.println("Kleiner");
                                if (higherthan > tip){
                                    higherthan = tip;
                                }
                            } else {
                                System.out.println("Größer");
                                if (lowerthan < tip){
                                    lowerthan = tip;
                                }
                            }
                            System.out.println(tips);
                            myTurn = !myTurn;
                        } while (tip != randomNr);

                        System.out.println("Möchtest du nochmal spielen(YES/NO)?");
                        answer = sc.next().toUpperCase().charAt(0);
                    } while (answer == 'Y');
                    break;


                case 0:
                    System.out.println("Spiel beendet!");


            }

        } while (level != 0);
    }
}
