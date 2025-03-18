import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;


public class CyberSecurityV1 {
    public static void main(String[] args) {
        List<Character> possibleCharacters = Arrays.asList('A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '!');


        //create Password
        Random r = new Random();

        int totalNrOfGusses = 0;
        int min = 1000;
        int max = 0;
        for (int x = 0; x < 1000; x++) {

            ArrayList password = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char randomElement = possibleCharacters.get(r.nextInt(possibleCharacters.size()));
                password.add(randomElement);

            }
            int nrOfGuesses = 0;
            System.out.println("Password: " + password);
            int nrPossibleChar = possibleCharacters.size();
            for (int i = 0; i < nrPossibleChar; i++) {
                for (int j = 0; j < nrPossibleChar; j++) {
                    for (int k = 0; k < nrPossibleChar; k++) {
                        for (int l = 0; l < nrPossibleChar; l++) {
                            ArrayList solution = new ArrayList();
                            solution.add(possibleCharacters.get(i));
                            solution.add(possibleCharacters.get(j));
                            solution.add(possibleCharacters.get(k));
                            solution.add(possibleCharacters.get(l));
                            nrOfGuesses++;
                            if (solution.equals(password)) {
                                System.out.println("Found it: " + solution + " == " + password);
                                System.out.println("Took " + nrOfGuesses + " guesses");
                                i = j = k = l = nrPossibleChar;
                            }
                        }

                    }

                }
            }
            totalNrOfGusses += nrOfGuesses;
            if (min > nrOfGuesses) {
                min = nrOfGuesses;
            }
            if (max < nrOfGuesses) {
                max = nrOfGuesses;
            }
        }
        System.out.println(totalNrOfGusses);
        int mean = (int) Math.round((double) totalNrOfGusses / 1000);
        System.out.println(mean);
        System.out.println(max);
        System.out.println(min);
        System.out.println(String.format("On average took %d guesses each time. Best case %d guesses, worst case was %d guesses.", mean, min, max));


    }
}
