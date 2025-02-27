import java.util.Random;
import java.util.Arrays;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {
        boolean sorted;

        //Random Array
        Random r = new Random();
        int[] array = new int[100];
        for (int i = 0; i < 100; i++){
            int x = r.nextInt(101);
            array[i] = x;
        }
        System.out.println("random Array: " + Arrays.toString(array));
        int arrayLength = array.length;

        // Sorting
        do{
            sorted = true;
            for (int i = 0; i < arrayLength; i++){
                for (int j = 0; j < arrayLength - 1 - i; j++){
                    if (array[j] > array[j + 1]){
                        sorted = false;
                        int x = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = x;
                    }
                }
            }
        } while (!sorted);
        System.out.println("Array sorted: " + Arrays.toString(array));
    }
}
