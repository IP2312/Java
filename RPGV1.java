import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.ArrayList;

public class RPGV1 {
    public static void main(String[] args) {
        int currentChoice = 0;
        int positonChoice = 2;
        int positionID = 1;
        int positionchoiceText = 3;
        int positionmovetoID = 4;
        int positionresultText = 3;
        boolean repeate;
        Scanner sc = new Scanner(System.in);

        String[][] choices = {
                //{parentID, ID, choiceText, moveToID}
                {"-1", "0", "", "Du stehst in einer Bar."},

                {"0", "1", "Geh in die Wildnis.", "Du bist in der Wildniss angekommen."},
                {"0", "2", "Trink ein Getränk.", "Du lässt die ein Getränk schmecken.", "0"},

                {"1", "3", "Kämpf gegen das Monster.", "Das Monster ist ein harter Gegner, aber du besiegst es", "1"},
                {"1", "4", "Lauf von dem Monster davon", "Du läufst wie ein Feigling zurück zut Bar", "0"},

        };


        do {
            //print state
            System.out.println(choices[currentChoice][positionresultText]);


            do {
                System.out.println("------------------------------------");
                //search for viable options and print them
                ArrayList<Integer> viableChoices = new ArrayList<>();
                for (int i = 0; i < choices.length; i++) {

                    if (choices[i][0].equals(choices[currentChoice][positionID])) {
                        viableChoices.add(i);
                        System.out.println(choices[i][positionID] + ".) " + choices[i][positonChoice]);
                    }
                }
                System.out.println("------------------------------------");

                do {
                    System.out.println("Was willst du als nächstes tun?");

                    currentChoice = sc.nextInt();
                } while (!viableChoices.contains(currentChoice));

                //print result of choice
                System.out.println(choices[currentChoice][positionchoiceText]);

                if (choices[currentChoice].length == 5) {
                    currentChoice = Integer.parseInt(choices[currentChoice][positionmovetoID]);
                    repeate = false;
                } else {
                    repeate = true;
                }
            } while (repeate);
        } while (true);
    }
}
