public class PseudoCode {
    public static void main(String[] args) {
        int n = 6;
        boolean primzahl = true;

        for (int k = 2; k < n && primzahl; k++){
            if ( n % k == 0){
                primzahl = false;
                System.out.println(n + " ist keine Primzahl");
            }
        }
        if (primzahl){
            System.out.println(n + " ist eine Primzahl");
        }
    }
}
