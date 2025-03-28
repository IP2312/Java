import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class RPGV2 {
    public static void main(String[] args) {
        int currentChoice = 0;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int lifeMax = 10;
        int mLife = 0;
        int pLife = lifeMax;
        int mAttack;
        int pGold = 0;
        int lute = 0;
        boolean gameOver = false;


        String[][] choices = {
                //{parentID, ID, choiceText, moveToID}
                {"-1", "0", "", "Du stehst in einer Bar."},

                {"0", "1", "Geh in die Wildnis auf der Suche nach Abenteuern", "Du bist in der Wildnis angekommen. Du triffst auf ein Monster."},
                {"0", "2", "Trink ein Getränk und raste dich aus", "Du lässt dir ein Getränk schmecken", "0"},
                {"0", "3", "Beeindrucke die Prinzessin mit deinen Schätzen", "Du gibst alles!", "0"},

                {"1", "4", "Kämpf gegen das Monster", "", "6"},
                {"1", "5", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},

                {"4", "6", "", ""},

                {"6", "7", "Versuche das Monster mit deinem Schwert zu erwischen", "Du wirfst dich in die Schlacht!", "6"},
                {"6", "8", "Es ist Zeit zu gehen", "Du versuchst zu flüchten, doch das Monster verfolgt dich.", "0"},

                {"-1", "9", "", "Deine Zeit ist leider vorüber. Der Tod erwartet dich schon mit freundlichem Grinsen"}, // TOD
                {"-1", "10", "", "Du bist der größte Held aller Zeiten! Hurra!"}, // SIEG
        };

        do {
            System.out.println(choices[currentChoice][3]);

            //find valid choices and display them
            System.out.println("-------------------------------");
            ArrayList<Integer> validOptions = new ArrayList<>();
            for (int i = 0; i < choices.length; i++) {
                if (choices[i][0] == choices[currentChoice][1]) {
                    validOptions.add(i);
                    System.out.println(i + ".) " + choices[i][2]);
                }
            }
            System.out.println("-------------------------------");
            System.out.println("Was möchtest du tun?");
            currentChoice = sc.nextInt();

            switch (currentChoice) {
                case 1:
                    ascii("monster");
                    break;
                case 2:
                    if (pGold >= 100 && pLife < lifeMax) {
                        pGold -= 100;

                        System.out.println(choices[currentChoice][3]);
                        if (pLife + 3 <= lifeMax) {
                            pLife += 3;
                            System.out.printf("Dein Lebensdurst kehrt zurück! +3 Leben, jetzt hast du wieder %d Leben!", pLife);
                        } else {
                            pLife = lifeMax;
                            System.out.println("Du bist vollständig geheilt!");
                        }
                        ascii("drink");
                    } else if (pGold < 100) {
                        ascii("money");
                        System.out.println("Du hast zu wenig Geld");
                    }
                    else {
                        System.out.println("Deine Gesundheit ist bereits maximal!");
                    }
                    currentChoice = Integer.parseInt(choices[currentChoice][4]);
                    break;
                case 3:
                    if (pGold >= 1000 && lifeMax >= 15) {
                        System.out.println(choices[10][3]);
                        ascii("heart");
                        gameOver = true;
                    } else {
                        System.out.println(choices[currentChoice][3]);
                        System.out.println("Die Prinzessin belächelt dich nur verächtlich. So einen armen Schlucker soll sie heiraten? Und so wenig Lebenserfahrung! Tz tz!");
                        System.out.printf("Du braucht noch sicher %d Gold dafür, Junge! Und %d Jahre Erfahrung!", 1000 - pGold, 15 - pLife);
                        System.out.println();
                        currentChoice = Integer.parseInt(choices[currentChoice][4]);
                    }
                    break;
                case 4:
                    mLife = r.nextInt(18) + 3;
                    lute = r.nextInt(mLife * 100) + 1;
                    System.out.printf("Das Monster hat insgesammt %d Leben, und du noch %d!", mLife, pLife);
                    currentChoice = Integer.parseInt(choices[currentChoice][4]);
                    break;
                case 5:
                    ascii("run");
                    System.out.println(choices[currentChoice][3]);
                    currentChoice = Integer.parseInt(choices[currentChoice][4]);
                    break;
                case 7:

                    int pAttack = r.nextInt(pLife) + 1;
                    System.out.println(choices[currentChoice][3]);
                    mLife -= pAttack;
                    System.out.printf("Du erwischt das Monster mit %d Schaden. Es hat noch %d Leben.\n", pAttack, mLife);
                    if (mLife <= 0) {
                        System.out.println("Du hast das Monster besiegt!");
                        lifeMax++;
                        pGold += lute;
                        System.out.printf("Du gewinnst an Erfahrung und hast jetzt %d maximale Lebenspunkte", lifeMax);
                        System.out.printf("Du findest in der Nähe des Monsters %d Gold - das du dir natürlich schnappst!\n", lute);
                        currentChoice = 1;
                    } else {
                        mAttack = r.nextInt(mLife) + 1;
                        pLife -= mAttack;
                        System.out.printf("Das Monster hat dich für %d Schaden erwischt. Du hast noch %d Leben.", mAttack, pLife);
                        if (pLife <= 0) {
                            gameOver = true;
                            System.out.println(choices[9][3]);
                        } else {
                            currentChoice = Integer.parseInt(choices[currentChoice][4]);
                        }
                    }

                    break;
                case 8:
                    System.out.println(choices[currentChoice][3]);
                    ascii("run");
                    mAttack = r.nextInt(mLife) + 1;
                    pLife -= mAttack;
                    System.out.printf("Das Monster hat dich für %d Schaden erwischt. Du hast noch %d Leben.\n", mAttack, pLife);
                    if (pLife <= 0) {
                        gameOver = true;
                        System.out.println(choices[9][3]);
                    } else {
                        currentChoice = Integer.parseInt(choices[currentChoice][4]);
                    }


            }


        } while (!gameOver);


    }

    static void ascii(String picture) {
        try {
            String asciiArt = new String(Files.readAllBytes(Paths.get(String.format("ASCII/%s.txt", picture))));
            System.out.println(asciiArt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
