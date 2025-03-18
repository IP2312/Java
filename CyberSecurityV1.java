import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;


public class CyberSecurityV1 {
    public static void main(String[] args) {
        List<Character> possibleCharacters = Arrays.asList('A', 'B', 'C', 'a', 'b', 'c', '0', '1', '2', '!');
        int turns = 1000;

        //create Password
        Random r = new Random();

        int totalNrOfGusses = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int x = 0; x < turns; x++) {

            ArrayList<Character> password = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char randomElement = possibleCharacters.get(r.nextInt(possibleCharacters.size()));
                password.add(randomElement);

            }

            int nrOfGuesses = 0;
            boolean found = false;
            System.out.println("Password: " + password);
            int nrPossibleChar = possibleCharacters.size();
            for (int i = 0; i < nrPossibleChar && !found; i++) {
                for (int j = 0; j < nrPossibleChar && !found; j++) {
                    for (int k = 0; k < nrPossibleChar && !found; k++) {
                        for (int l = 0; l < nrPossibleChar && !found; l++) {
                            ArrayList<Character> solution = new ArrayList<>();
                            solution.add(possibleCharacters.get(i));
                            solution.add(possibleCharacters.get(j));
                            solution.add(possibleCharacters.get(k));
                            solution.add(possibleCharacters.get(l));
                            nrOfGuesses++;
                            if (solution.equals(password)) {
                                System.out.println("Found it: " + solution + " == " + password);
                                System.out.println("Took " + nrOfGuesses + " guesses");
                                found = true;
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
        int mean = (int) Math.round((double) totalNrOfGusses / turns);
        System.out.println(String.format("On average took %d guesses each time. Best case %d guesses, worst case was %d guesses.", mean, min, max));

    }
}
