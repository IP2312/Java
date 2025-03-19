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
                System.out.println("Welches Level möchtest du spielen? Lv:(1 2 3) 4 zum beenden");
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
                            System.out.println("Gib einen Tip ab.");
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

                case 2:
                    do {
                        int randomNr = r.nextInt(101);
                        System.out.println(randomNr);
                        int tries = 0;
                        int tip;

                        ArrayList<Integer> tips = new ArrayList<>();
                        do {
                            System.out.println("Gib einen Tip ab.");
                            tip = sc.nextInt();
                            tries++;
                            if (tip == randomNr) {
                                System.out.println("Erraten");
                            } else {
                                if (Math.abs(randomNr - tip) <= 3) {
                                    System.out.println("fast da");
                                } else if (Math.abs(randomNr - tip) <= 10) {
                                    System.out.println("relativ nahe");
                                } else if (Math.abs(randomNr - tip) <= 20) {
                                    System.out.println("Nicht ganz so weit weg");
                                } else {
                                    System.out.println("Weit weg");
                                }
                                System.out.println(String.format("Noch %d Versuche", 9 - tries));
                                tips.add(tip);
                                System.out.println("Tips: " + tips);
                            }
                        } while (tip != randomNr && tries < 9);
                        System.out.println("Möchtest du nochmal spielen(YES/NO)?");
                        answer = sc.next().toUpperCase().charAt(0);
                    } while (answer == 'Y');

                case 3:
                    do {
                        int randomNr = r.nextInt(101);
                        System.out.println(randomNr);
                        int tip;
                        boolean myTurn = r.nextBoolean();
                        int bigger = 100;
                        int smaller = 0;
                        ArrayList<Integer> tips = new ArrayList<>();
                        do {
                            if (myTurn) {
                                System.out.println("Gib einen Tip ab.");
                                tip = sc.nextInt();

                                myTurn = false;
                            } else {
                                //calculate tip of computer

                                tip = smaller + (bigger - smaller)/2;
                                System.out.println("Tip des Computers: " + tip);

                                myTurn = true;
                            }
                            tips.add(tip);
                            if (tip == randomNr) {
                                System.out.println("Erraten");
                            } else if (tip > randomNr) {
                                System.out.println("Kleiner");
                                if (bigger > tip){
                                    bigger = tip;
                                }
                            } else {
                                System.out.println("Größer");
                                if (smaller < tip){
                                    smaller = tip;
                                }
                            }
                            System.out.println(tips);
                        } while (tip != randomNr);

                        System.out.println("Möchtest du nochmal spielen(YES/NO)?");
                        answer = sc.next().toUpperCase().charAt(0);
                    } while (answer == 'Y');


                case 4:
                    System.out.println("Spiel beendet!");


            }

        } while (level != 4);
    }
}
