import java.util.Arrays;
import java.util.Random;

public class GaudiMitArraysV1 {
    public static void main(String[] args) {

        //Array1
        int array1[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(array1));

        //Array2
        Random r = new Random();
        int[] array2 = new int[100];
        for (int i = 0; i < 100; i++){
            int x = r.nextInt(101);
            array2[i] = x;
        }
        System.out.println(Arrays.toString(array2));

        //Array 3
        int array_length = 10;
        boolean[] array3 = new boolean[array_length];
        for (int i = 0; i < array_length; i += 2){
            array3[i] = true;
        }
        System.out.println(Arrays.toString(array3));

    }
}
