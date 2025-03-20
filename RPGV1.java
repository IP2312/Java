public class RPGV1 {
    public static void main(String[] args) {
        int currentChoice = 0;
        String[][] choices = {
                //{parentID, ID, choiceText, moveTo ID}
                {"-1", "0", "Du stehst in einer Bar."},

                {"0", "1", "Geh in die Wildnis.", "Du bist in der Wildniss angekommen."},
                {"0", "2", "Trink ein Getränk.", "Du lässt die ein Getränk schmecken.", "0"},

                {"1", "3", "Kämpf gegen das Monster.", "Du bist in der Wildniss angekommen.","1"},
                {"1", "4", "Lauf von dem Monster davon", "Du läufst wie ein Feigling zurück zut Bar", "0"},

        };
    }
}
