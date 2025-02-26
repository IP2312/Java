public class KleinerAlgorithmusV1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int counter = 6;

        for (int i = 0; i < counter; i++){
            int c = a + b;
            System.out.println(a + " + " + b + " = " + c);
            a = b;
            b = c;
        }
    }
}
