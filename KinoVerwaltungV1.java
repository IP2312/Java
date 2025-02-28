public class KinoVerwaltungV1 {
    public static void main(String[] args) {
        //populate array for monitor
        String[][] movie = {
                {"Heldin", "20:15","2","available"},
                {"A Real Pain", "20:15","2","available"},
                {"Anora", "20:15","2","available"},
                {"Bagman", "20:15","2","available"},
        };
        //print monitor displaying movie title, time, movie theatre, availability
        for (int i = 0; i < movie.length; i++) {
            String formatter = "%-15s %-10s %-8s %-5s\n";
            System.out.printf(formatter, movie[i][0], movie[i][1], movie[i][2], movie[i][3]);
        }
        //ask how much money

        //ask which movie until available movie selected or quit

        // if  available movie selected ask for number of tickets
        // if has enough money and seats are available subtract money and available seats from movie

        //continue until user enters 0

    }
}
