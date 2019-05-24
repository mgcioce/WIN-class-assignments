import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args) {

        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        BigInteger n = new BigInteger(kb.next());
        kb.nextLine();
        do {
            Integer[] array = new Integer[n.intValue()];
            Random randomNumbers = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.valueOf(randomNumbers.nextInt(100));
            }
            Instant start = Instant.now();
            Sort.selectionSort(array,true);
            Instant finish = Instant.now();
            double timeElapsed = Duration.between(start,finish).getNano()/1_000_000_000.00;
            System.out.println("Selection Sort: " + timeElapsed + " seconds to run");
            for (Integer i: array) {
                System.out.print(" " + i.toString());
            }
            System.out.println("\nDo you want to go again?");
        } while(kb.nextLine().compareToIgnoreCase("Y") == 0);

    }
}
