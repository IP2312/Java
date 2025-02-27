public class GaudiMitArraysV2 {
    public static void main(String[] args) {
        int howMuch = -55;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        howMuch = howMuch % 26;
        if (howMuch < 0){
            howMuch += 26;
        }
        char[] array = chars.toCharArray();
        for (int i = 0; i < chars.length(); i++) {
            int z = chars.charAt(i) + howMuch;
            if (z > 'Z') {
                z -= 26;
            }
            array[i] = (char) z;
        }
        System.out.println(array);
    }
}
