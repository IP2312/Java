import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class KinoverwaltungV2_2 {
    public static void main(String[] args) {
        int movie;
        int seats;
        double money = 0;
        ArrayList<Integer> boughtMovies = new ArrayList<Integer>();
        String[][] movies = {
                {"Heldin", "20:15", "2", "12.00", "10"},
                {"A Real Pain", "20:15", "2", "13.00", "12"},
                {"Anora", "20:15", "2", "14.50", "0"},
                {"Bagman", "20:15", "2", "15.99", "4"},
        };
        String[] possibleChoices = {"Ticket kaufen", "Film ansehen", "Gewinnspiel", "Kino verlassen"};
        Scanner sc = new Scanner(System.in);
        //ask how much money
        do {
            System.out.println("Wie viel Geld hast du bei dir?");
            money = sc.nextDouble();
            if (money <= 0) {
                System.out.println("Betrag muss mehr als 0€ sein");
            }
        } while (money <= 0);

        int choice;
        do {
            System.out.println(String.format("Was möchtest du als nächstes tun? (Du hast noch %.2f€)", money));
            for (int i = 0; i < possibleChoices.length; i++) {
                System.out.println(String.format("%d. %s", i + 1, possibleChoices[i]));
            }
            choice = sc.nextInt();


            switch (choice) {
                case 1:// Ticket kaufen
                    do {

                        String formatter_title = "%8s %17s %6s  %6s %10s\n";
                        System.out.printf(formatter_title, "Title", "Uhrzeit", "Saal", "Preis", "Restplätze");
                        System.out.println("----------------------------------------------------");

                        //print monitor displaying movie title, time, movie theatre, availability
                        String formatter_content = "%d. %-15s %-10s %-5s %-3s€ %6s\n";

                        for (int i = 0; i < movies.length; i++) {
                            int seat = Integer.parseInt(movies[i][4]);
                            String availability;
                            if (seat > 0) {
                                availability = "verfügbar";
                            } else {
                                availability = "ausgebucht";
                            }
                            System.out.printf(formatter_content, i + 1, movies[i][0], movies[i][1], movies[i][2], movies[i][3], availability);
                        }
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Welchen Film möchtest du kaufen? (0 zum abbrechen)");
                        movie = sc.nextInt();
                        if (movie > 0 && movie <= movies.length) {
                            seats = Integer.parseInt(movies[movie - 1][4]);
                            if (seats > 0) {
                                // if  available movie selected ask for number of tickets
                                System.out.println(String.format("Es sind noch %d tickets zu je 15€ verfügbar. Wie viele möchtest du kaufen?", seats));
                                int gekaufteTickets = sc.nextInt();
                                if (gekaufteTickets <= 0) {
                                    System.out.println("Anzahl der Tickets darf nicht 0 oder kleiner sein.");
                                } else if (gekaufteTickets > seats) {
                                    System.out.println("Es sind nicht genügend Plätze vorhanden");
                                } else {
                                    double price = gekaufteTickets * Double.parseDouble(movies[movie - 1][3]);
                                    if (price <= money) {
                                        money -= price;
                                        System.out.println(String.format("Du hast %d Tickets  um %.2f€ gekauft und hast jetzt noch %.2f€", gekaufteTickets, price, money));
                                        // if has enough money and seats are available subtract money and available seats from movie
                                        int remainingSeats = seats - gekaufteTickets;
                                        movies[movie - 1][4] = String.valueOf(remainingSeats);
                                        for (int i = 0; i < gekaufteTickets; i++) {
                                            boughtMovies.add(movie);
                                        }
                                    } else {
                                        System.out.println("Du hast nicht genug Geld.");
                                    }
                                }
                            } else {
                                System.out.println("Film ausgebucht");
                            }
                        } else if (movie != 0) {
                            System.out.println("Wähle einen der angezeigten Filme.");
                        }
                    } while (movie != 0);
                    System.out.println("Auswahl beendet");
                    break;


                case 2://Film ansehen
                    //gekaufte Filme anzeigen
                    boughtMovies.sort(Comparator.naturalOrder());
                    System.out.println("Welchen Film möchtest du sehen? (0 für abbrechen)");
                    for (int i = 0; i < boughtMovies.size(); i++) {
                        System.out.println(i + 1 + "." + movies[boughtMovies.get(i) - 1][0]);
                    }
                    int chosenMovie = sc.nextInt();
                    if (chosenMovie > 0 && chosenMovie <= boughtMovies.size()) {
                        System.out.println(String.format("Du schaust den Film %s an. Viel Spaß!", movies[boughtMovies.get(chosenMovie-1)][0]));
                        boughtMovies.remove(chosenMovie - 1);
                    }

                case 3: //Gewinnspiel




            }
        }
        while (choice != 4);


    }
}
