public class GaudiMitStatistikV1 {
    public static void main(String[] args) {
        String sentence = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        int upper = 0;
        int lower = 0;
        int number = 0;
        int other = 0;

        int sentenceSize = sentence.length();
        for (int i = 0; i < sentenceSize; i++) {
            int z = sentence.charAt(i);
            if (z >= 65 && z <= 90) {
                upper++;
            } else if (z >= 97 && z <= 122) {
                lower++;
            } else if (z >= 48 && z <= 57) {
                number++;
            }
            else{
                other++;
            }
        }
        System.out.println("Content: " + sentence);
        System.out.println("Großbuchstaben: " + upper);
        System.out.println("Kleinbuchstaben: " + lower);
        System.out.println("Zahlen: " + number);
        System.out.println("Sonstige Zeichen: " + other);

    }
}
