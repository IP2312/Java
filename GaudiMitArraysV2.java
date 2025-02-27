public class GaudiMitArraysV2 {
    public static void main(String[] args) {
        int howMuch = 3;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char [] array = chars.toCharArray();
        for (int i = 0; i < chars.length(); i++){
            int z = chars.charAt(i);
            z = z + howMuch;
            array[i] = (char)z;
            System.out.println(array);
        }
        System.out.println(array);
    }
}
