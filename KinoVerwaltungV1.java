import java.util.Scanner;

public class KinoVerwaltungV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ask how much money
        System.out.println("Wie viel Geld hast du bei dir?");
        int money = sc.nextInt();
        //populate array for monitor
        String[][] movie = {
                {"Titel", "Uhrzeit", "Saal", "Restplätze"},
                {"Heldin", "20:15","2","available"},
                {"A Real Pain", "20:15","2","available"},
                {"Anora", "20:15","2","available"},
                {"Bagman", "20:15","2","available"},
        };
        String formatter = "%d. %-15s %-10s %-8s %6s\n";
        System.out.printf(formatter, 0,movie[0][0], movie[0][1], movie[0][2], movie[0][3]);
        System.out.println("------------------------------------------------");
        //print monitor displaying movie title, time, movie theatre, availability
        for (int i = 1; i < movie.length; i++) {
            System.out.printf(formatter, i, movie[i][0], movie[i][1], movie[i][2], movie[i][3]);
        }
        System.out.println("------------------------------------------------");

        //ask which movie until available movie selected or quit
        boolean available = true;
        do {
            System.out.println("Welchen Film möchtest du sehen?");

        }while (!available);
        // if  available movie selected ask for number of tickets
        // if has enough money and seats are available subtract money and available seats from movie

        //continue until user enters 0

    }
}
