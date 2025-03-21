import java.util.Scanner;
import java.util.ArrayList;

public class RPGV2 {
    public static void main(String[] args) {
        int currentChoice = 0;
        Scanner sc = new Scanner(System.in);
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

        do{
            System.out.println(choices[currentChoice][3]);

            //find valid choices and display them
            System.out.println("-------------------------------");
            ArrayList <Integer> validOptions = new ArrayList<>();
            for (int i = 0; i < choices.length; i++) {
                if (choices[i][0] == choices[currentChoice][1]){
                    validOptions.add(i);
                    System.out.println(i + ".) " + choices[i][2]);
                }
            }
            System.out.println("-------------------------------");
            System.out.println("Was möchtest du tun?");
            currentChoice = sc.nextInt();

            if (choices[currentChoice].length == 5){
                System.out.println(choices[currentChoice][3]);
                currentChoice = Integer.parseInt(choices[currentChoice][4]);

            }
        }while (true);
    }
}
