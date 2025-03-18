import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;


public class CyberSecurityV1 {
    public static void main(String[] args) {
        List<Character> possibleCharacters = Arrays.asList('A','B','C','a','b','c','0','1','2','!');


        //create Password
        ArrayList password = new ArrayList<>();
        Random r = new Random();


        for (int i = 0; i < 4; i++){
            char randomElement = possibleCharacters.get(r.nextInt(possibleCharacters.size()));
            password.add(randomElement);

        }
        int nrOfGuesses = 0;
        System.out.println("Password: " + password);
        int nrPossibleChar = possibleCharacters.size();
        for (int i = 0; i < nrPossibleChar; i++) {
            for (int j = 0; j < nrPossibleChar; j++) {
                for (int k = 0; k <nrPossibleChar; k++) {
                    for (int l = 0; l < nrPossibleChar; l++) {
                        ArrayList solution = new ArrayList();
                        solution.add(possibleCharacters.get(i));
                        solution.add(possibleCharacters.get(j));
                        solution.add(possibleCharacters.get(k));
                        solution.add(possibleCharacters.get(l));
                        nrOfGuesses++;
                        if (solution.equals(password)){
                            System.out.println("Found it: " + solution + " == " + password);
                            System.out.println("Took " + nrOfGuesses + " guesses");
                            i=j=k=l=nrPossibleChar;
                        }
                    }
                    
                }
                
            }
            
        }

    }
}
