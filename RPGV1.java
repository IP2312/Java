import java.util.Scanner;
import java.util.ArrayList;

public class RPGV1 {
    public static void main(String[] args) {
        int currentChoice = 0;
        int positonChoice = 2;
        int positionID = 1;
        int positionchoiceText = 3;
        int movetoID = 0;
        int positionmovetoID = 4;

        int resultText = 3;

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
            System.out.println(choices[currentChoice][resultText]);
            currentChoice = movetoID;



            do {
                System.out.println("-----------------------");
                //search for viable options and print them
                ArrayList<Integer> viableChoices = new ArrayList<>();
                for (int i = 0; i < choices.length; i++) {

                    if (choices[i][0].equals(choices[currentChoice][positionID])) {
                        viableChoices.add(i);
                        System.out.println(choices[i][positionID] + ".) " + choices[i][positonChoice]);
                    }
                }
                System.out.println("-----------------------");
                System.out.println("Was willst du als nächstes tun?");
                currentChoice = sc.nextInt();
                //print result of choice
                System.out.println(choices[currentChoice][positionchoiceText]);

                if (choices[currentChoice].length > 4) {
                    movetoID = Integer.valueOf(choices[currentChoice][positionmovetoID]);
                }
            }while (choices[currentChoice].length <= 4);


        } while (true);
    }
}
