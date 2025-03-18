import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;


public class CyberSecurityV1 {
    public static void main(String[] args) {
        //int [] possibleCharacters = {'A','B','C','a','b','c',0,1,2,'!'};
        List<Character> possibleCharacters = Arrays.asList('A','B','C','a','b','c','0','1','2','!');
        System.out.println(possibleCharacters);


        //create Password
        ArrayList password = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 4; i++){
            char randomElement = possibleCharacters.get(r.nextInt(possibleCharacters.size()));
            System.out.println(randomElement);

        }
        System.out.println(password);

    }
}
