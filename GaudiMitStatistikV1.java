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
            if (z >= 'A' && z <= 'Z') {
                upper++;
            } else if (z >= 'a' && z <= 'z') {
                lower++;
            } else if (z >= '1' && z <= '9') {
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
