import java.util.Arrays;
import java.util.Random;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {
        final int arrayLength = 10;


        //Random Array
        Random r = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int x = r.nextInt(101);
            randomArray[i] = x;
        }

        System.out.println("Urliste:");
        for (int i = 0; i <  arrayLength ; i++) {
            System.out.print("[" + randomArray[i] + "]");
        }
        System.out.println();

        // Sorting
        boolean sorted;
        int[] sortedArray;
        sortedArray = randomArray;
        do{
            sorted = true;
            for (int i = 0; i < arrayLength; i++){
                for (int j = 0; j < arrayLength - 1 - i; j++){
                    if (sortedArray[j] > sortedArray[j + 1]){
                        sorted = false;
                        int x = sortedArray[j];
                        sortedArray[j] = sortedArray[j + 1];
                        sortedArray[j + 1] = x;
                    }
                }
            }
        } while (!sorted);
        System.out.println("Aufsteigend sortiert:");
        for (int i = 0; i <  arrayLength ; i++) {
            System.out.print("[" + sortedArray[i] + "]");
        }
        System.out.println();

        //calculate mean


        int sum = 0;
        for (int i = 0; i < arrayLength; i++) {
            sum += randomArray[i];
        }
        double mean = (double)sum/arrayLength;
        System.out.println(String.format("Aritmethisches Mittel: %.1f", mean));
        System.out.println("Spannweite: " + (sortedArray[arrayLength -1] - sortedArray[0]));

        //median
        double median;
        if (arrayLength % 2 == 0){
            int middle = arrayLength/2;
            median = (double)(sortedArray[middle] + sortedArray[middle + 1])/2;
        }
        else {
            median = sortedArray[arrayLength/2];
        }
        System.out.println(String.format("Median: %.1f", median));
        System.out.println("test");



    }
}
