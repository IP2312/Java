import java.util.Scanner;

public class KinoVerwaltungV1 {
    public static void main(String[] args) {
        int movie = 0;
        int seats;
        double money;
        String[][] movies = {
                {"Titel", "Uhrzeit", "Saal", "Restplätze"},
                {"Heldin", "20:15", "2", "10"},
                {"A Real Pain", "20:15", "2", "12"},
                {"Anora", "20:15", "2", "0"},
                {"Bagman", "20:15", "2", "4"},
        };

        Scanner sc = new Scanner(System.in);
        //ask how much money
        boolean valid;
        do{
            System.out.println("Wie viel Geld hast du bei dir?");
            money = sc.nextDouble();
            if(...){
                ...;
            }
        }while (money <= 0 || !valid);

        //display monitor
        do{
            String formatter_title = "%-2s %-14s %-10s %-8s %6s\n";
            System.out.printf(formatter_title, "", movies[0][0], movies[0][1], movies[0][2], movies[0][3]);
            System.out.println("------------------------------------------------");
            //print monitor displaying movie title, time, movie theatre, availability
            String formatter_content = "%d. %-15s %-10s %-8s %6s\n";
            for (int i = 1; i < movies.length; i++) {
                int seat = Integer.parseInt(movies[i][3]);
                String availability;
                if (seat > 0) {
                    availability = "verfügbar";
                } else {
                    availability = "ausgebucht";
                }
                System.out.printf(formatter_content, i, movies[i][0], movies[i][1], movies[i][2], availability);
            }
            System.out.println("------------------------------------------------");

            //ask which movie until available movie selected or quit

            System.out.println("Welchen Film möchtest du sehen?");
            movie = sc.nextInt();
            if (movie > 0 && movie < movies.length) {
                seats = Integer.parseInt(movies[movie][3]);
                if (seats != 0) {
                    // if  available movie selected ask for number of tickets
                    System.out.println(String.format("Es sind noch %d tickets zu je 15€ verfügbar. Wie viele möchtest du kaufen?", seats));
                    int gekaufteTickets = sc.nextInt();
                    int preis = gekaufteTickets * 15;
                    if (preis <= money) {
                        double budget = money - preis;
                        System.out.println(String.format("Du hast %d Tickets  um %d€ gekauft und hast jetzt noch %.2f€", gekaufteTickets, preis, budget));
                        // if has enough money and seats are available subtract money and available seats from movie
                        int remainingSeats = seats - gekaufteTickets;
                        movies[movie][3] = String.valueOf(remainingSeats);
                    }
                }
            }
        }while (movie != 0);
    }
}
