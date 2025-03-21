import java.util.Scanner;
import java.util.ArrayList;

public class RPGV1 {
    public static void main(String[] args) {
        int currentChoice = 0;
        final int positionID = 1;
        final int positionChoice = 2;
        final int positionchoiceTxt = 3;
        final int positionmovetoID = 4;
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
            System.out.println(choices[currentChoice][positionchoiceTxt]);


            System.out.println("------------------------------------");
            //search for viable options and print them
            ArrayList<Integer> viableChoices = new ArrayList<>();
            for (int i = 0; i < choices.length; i++) {

                if (choices[i][0].equals(choices[currentChoice][positionID])) {
                    viableChoices.add(i);
                    System.out.println(choices[i][positionID] + ".) " + choices[i][positionChoice]);
                }
            }
            System.out.println("------------------------------------");

            do {
                System.out.println("Was willst du als nächstes tun?");

                currentChoice = sc.nextInt();
            } while (!viableChoices.contains(currentChoice));


            if (choices[currentChoice].length == 5) {
                //print result of choice
                System.out.println(choices[currentChoice][positionchoiceTxt]);
                currentChoice = Integer.parseInt(choices[currentChoice][positionmovetoID]);
            }

        } while (true);
    }
}
