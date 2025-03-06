import java.util.Scanner;

public class KinoVerwaltungV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ask how much money
        System.out.println("Wie viel Geld hast du bei dir?");
        int money = sc.nextInt();
        //populate array for monitor
        String[][] movies = {
                {"Titel", "Uhrzeit", "Saal", "Restplätze"},
                {"Heldin", "20:15","2","10"},
                {"A Real Pain", "20:15","2","12"},
                {"Anora", "20:15","2","0"},
                {"Bagman", "20:15","2","4"},
        };
        String formatter = "%d. %-15s %-10s %-8s %6s\n";
        System.out.printf(formatter, 0,movies[0][0], movies[0][1], movies[0][2], movies[0][3]);
        System.out.println("------------------------------------------------");
        //print monitor displaying movie title, time, movie theatre, availability
        for (int i = 1; i < movies.length; i++) {
            int seat = Integer.parseInt(movies[i][3]);
            String availability;
            if (seat > 0){
                availability = "verfügbar";
            }
            else{
                availability ="ausgebucht";
            }
            System.out.printf(formatter, i, movies[i][0], movies[i][1], movies[i][2], availability);
        }
        System.out.println("------------------------------------------------");

        //ask which movie until available movie selected or quit
        boolean available = true;
        int movie;
        int seat;
        do {
            System.out.println("Welchen Film möchtest du sehen?");
            movie = sc.nextInt();
            if (movie <= movies.length){
                seat = Integer.parseInt(movies[movie - 1][3]);
                if (seat == 0){
                    available = false;
                }else {
                    available = true;
                }
            }
        }while (!available);
        // if  available movie selected ask for number of tickets

        // if has enough money and seats are available subtract money and available seats from movie

        //continue until user enters 0

    }
}
