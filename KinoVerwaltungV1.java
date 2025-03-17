import java.util.Scanner;
import java.util.ArrayList;

public class KinoVerwaltungV1 {
    public static void main(String[] args) {
        int movie;
        int seats;
        double money = 0;
        ArrayList <Integer> moviesWatched = new ArrayList <Integer>();
        String[][] movies = {
                {"Heldin", "20:15", "2", "10"},
                {"A Real Pain", "20:15", "2", "12"},
                {"Anora", "20:15", "2", "0"},
                {"Bagman", "20:15", "2", "4"},
        };

        Scanner sc = new Scanner(System.in);
        //ask how much money
        do {
            System.out.println("Wie viel Geld hast du bei dir?");
            money = sc.nextDouble();
            if (money <= 15) {
                System.out.println("Betrag muss mehr als 15€ sein");
            }
        } while (money <= 15);

        //display monitor
        do {
            String formatter_title = "%8s %17s %6s %15s\n";
            System.out.printf(formatter_title, "Title", "Uhrzeit", "Saal", "Restplätze");
            System.out.println("----------------------------------------------------");
            //print monitor displaying movie title, time, movie theatre, availability
            String formatter_content = "%d. %-15s %-10s %-8s %6s\n";

            for (int i = 0; i < movies.length; i++) {
                int seat = Integer.parseInt(movies[i][3]);
                String availability;
                if (seat > 0) {
                    availability = "verfügbar";
                } else {
                    availability = "ausgebucht";
                }
                System.out.printf(formatter_content, i + 1, movies[i][0], movies[i][1], movies[i][2], availability);
            }
            System.out.println("-----------------------------------------------------");

            //ask which movie until available movie selected or quit

            System.out.println("Welchen Film möchtest du sehen?");
            movie = sc.nextInt();
            if (movie > 0 && movie <= movies.length) {
                seats = Integer.parseInt(movies[movie - 1][3]);
                if (seats > 0) {
                    // if  available movie selected ask for number of tickets
                    System.out.println(String.format("Es sind noch %d tickets zu je 15€ verfügbar. Wie viele möchtest du kaufen?", seats));
                        int gekaufteTickets = sc.nextInt();
                        if (gekaufteTickets <= 0) {
                            System.out.println("Anzahl der Tickets darf nicht 0 oder kleiner sein.");
                        } else if (gekaufteTickets > seats) {
                            System.out.println("Es sind nicht genügend Plätze vorhanden");
                        } else {
                            int preis = gekaufteTickets * 15;
                            if (preis <= money) {
                                money -= preis;
                                System.out.println(String.format("Du hast %d Tickets  um %d€ gekauft und hast jetzt noch %.2f€", gekaufteTickets, preis, money));
                                // if has enough money and seats are available subtract money and available seats from movie
                                int remainingSeats = seats - gekaufteTickets;
                                movies[movie - 1][3] = String.valueOf(remainingSeats);
                                for (int i = 0; i < gekaufteTickets; i++){
                                    moviesWatched.add(movie);
                                }
                            } else {
                                System.out.println("Du hast nicht genug Geld.");
                            }
                        }
                } else {
                    System.out.println("Film ausgebucht");
                }
            } else {
                System.out.println("Wähle einen der angezeigten Filme.");
            }

    } while(movie != 0);
        System.out.println("Filme: " + moviesWatched);
}
}
