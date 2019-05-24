import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

    public static void main(String [] args) {
        ArrayListPractice alp = new ArrayListPractice();
        System.out.println(alp.toString());
        HashMapPractice hmp = new HashMapPractice();
        System.out.println(hmp.toString());
        arrayListCalc();
        carDealership();
    }

    public static void arrayListCalc() {
        Scanner kb = new Scanner(System.in);
        double[] numbers = new double[5];
        System.out.println("\nPlease give me five numbers delimited by a single space:\n");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Double.parseDouble(kb.next());
        }
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double product = 1;
        boolean first = true;
        for (double d: numbers) {
            if (first) {
                max = d;
                min = d;
                first = false;
            }
            sum += d;
            product *= d;
            if (d > max) {
                max = d;
            }
            if (d < min) {
                min = d;
            }
        }
        System.out.println(String.format("numbers: %f %f %f %f %f\nsum: %f\nproduct: %f\n" +
                                            "min: %f\nmax: %f\n",
                                            numbers[0], numbers[1], numbers[2], numbers[3],
                                            numbers[4], sum, product, min, max));
    }

    public static void carDealership() {
        Scanner kb = new Scanner(System.in);
        HashMap<String, ArrayList<String>> carLot = new HashMap<>();

        do{
            System.out.println("Car Lot Database: Add a car to the lot registry (year make model)" +
                    "\n For example: '2018 Honda Civic'\n");
            String nextCar = kb.nextLine();
            String[] yearMakeModel = nextCar.split("\\s");
            ArrayList<String> list;
            if (carLot.containsKey(yearMakeModel[2].toLowerCase())) { // if the car model is there, add it to the list
                list = carLot.get(yearMakeModel[2].toLowerCase());
                System.out.println("I'm here");

            } else { //the car model is not in the lot, so add it
                list = new ArrayList<>();

            }
            list.add(nextCar);
            System.out.println(list.toString());
            carLot.put(yearMakeModel[2].toLowerCase(),list);
            System.out.println("Add another car? (Y/N)");
        } while(kb.nextLine().compareToIgnoreCase("Y") == 0);

        System.out.println("Hi there! what kind of car are you looking for? (enter the model, e.g " +
                            "Civic)");
        boolean found;
        do{
            found = false;
            String ui = kb.nextLine().toLowerCase();
            if (ui.compareToIgnoreCase("N") == 0) {
                System.out.println("Have a good day!");
                break;
            }
            if (carLot.containsKey(ui)) {
                found = true;
                ArrayList<String> list = carLot.get(ui);
                String outputString = "Right this way! we have";
                for (int i = 0; i < list.size(); i++) {
                    if (i + 1 == list.size()) {
                        if (list.size() > 1) {
                            outputString += " and a " + list.get(i) + ".\n";
                        } else {
                            outputString += " a " + list.get(i) + ".\n";
                        }
                    } else {
                        outputString += " a " + list.get(i) + ",";
                    }
                }
                System.out.println(outputString);
                System.out.println("is there something else you would like to look at? (Y/N)");
                if (kb.nextLine().compareToIgnoreCase("Y") == 0) {
                    found = false;
                    System.out.println("What can I interest you in?");
                }
            } else {
                System.out.println("I'm sorry, we don't have that model. Is there another car I can " +
                                    "interest you in? (enter N to leave)");
            }

        }while(!found);
    }

}
