import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static void main(String [] args) {

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        BigInteger n = new BigInteger(kb.next());
        kb.nextLine();
        System.out.println("Ascending or Descending? (A/D)");
        boolean ascending;
        if (kb.nextLine().compareToIgnoreCase("A") == 0) {
            ascending = true;
        } else {
            ascending = false;
        }
        System.out.println("What would you like your sample size to be?");
        int sampleSize = kb.nextInt();
        // number of algorithms to run:
        int algorithms = 3;
        Integer[][] arrayCopies = new Integer[algorithms][n.intValue()];
    }
}

//        for (int j = 0; j < sampleSize; j++) {
//        Integer[] array = new Integer[n.intValue()];
//        Random randomNumbers = new Random();
//        for (int i = 0; i < array.length; i++) {
//        array[i] = Integer.valueOf(randomNumbers.nextInt(100));
//        }
//        for (int i = 0; i < algorithms; i++) {
//        arrayCopies[i] = Arrays.copyOf(array,array.length);
//        }
//        //selection sort
//        Instant start = Instant.now();
//        Sort.selectionSort(arrayCopies[0],ascending);
//        Instant finish = Instant.now();
//        double timeElapsed = Duration.between(start,finish).getNano()/1_000_000_000.00;
//        System.out.println("Selection Sort: " + timeElapsed + " seconds to run");
//        for (Integer i: arrayCopies[0]) {
//        System.out.print(" " + i.toString());
//        }
//        System.out.println();
//        //insertion sort
//        start = Instant.now();
//        Sort.insertionSort(arrayCopies[1],ascending);
//        finish = Instant.now();
//        timeElapsed = Duration.between(start,finish).getNano()/1_000_000_000.00;
//        System.out.println("Insertion Sort: " + timeElapsed + " seconds to run");
//        for (Integer i: arrayCopies[1]) {
//        System.out.print(" " + i.toString());
//        }
//        //bubble sort
//        start = Instant.now();
//        Sort.bubbleSort(arrayCopies[2],ascending);
//        finish = Instant.now();
//        timeElapsed = Duration.between(start,finish).getNano()/1_000_000_000.00;
//        System.out.println("\nBubble Sort: " + timeElapsed + " seconds to run");
//        for (Integer i: arrayCopies[1]) {
//        System.out.print(" " + i.toString());
//        }
