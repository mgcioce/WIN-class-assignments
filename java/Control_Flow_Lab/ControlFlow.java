import java.util.Scanner;
import java.util.ArrayList;

public class ControlFlow {
    public static void main(String [] args) {
         // scanner reads input from the command line 
         //through various methods
        Scanner scanner = new Scanner(System.in);
        String[] prompts = {"Enter your name:",
                        "Enter your age:",
                        "(E)mployed, (U)nemployed, or (S)tudent",
                        "(C)ar,(T)ruck,(S)UV,(O)ther, or (N)one"};
        String[] responses = new String[4];
        String redo = "";
        do {
            for (int i = 0; i < prompts.length; i++) {
            System.out.println(prompts[i]);
            responses[i] = scanner.next();
            }
            String response = new String("");
            String[] positiveResponses = {"You are old enough to drive\n",
                                "You are old enough to vote\n",
                                "You are old enough to drink\n",
                                "You are old enough to be President\n",
                                "You can join AARP\n"};
            String[] negativeResponses = {"You can't drive\n",
                                "You can't vote\n",
                                "You can't drink\n",
                                "You can't be President\n",
                                "You can't join AARP\n"};
            String[] employmentStatus = {"You are Employed\n",
                                    "You are Unemployed\n",
                                    "You are a Student\n"};
            String[] vehicleStatus = {"You own a car\n",
                                "You own a truck\n",
                                "You own an SUV\n",
                                "You own a vehicle\n",
                                "You don't own a vehicle\n"};
            int[] thresholds = {16,18,21,35,55};
            String[][] responseArray = {positiveResponses,
                                negativeResponses,
                                employmentStatus,
                                vehicleStatus};
            for (int i = 0; i < thresholds.length; i++){
                if (Integer.parseInt(responses[1]) >= thresholds[i]) {
                    response = response.concat(responseArray[0][i]);
                } else {
                    response = response.concat(responseArray[1][i]);
                }
            }
            switch(responses[2]) {
                case "E": {
                    response = response.concat(responseArray[2][0]);
                    break;
                }
                case "U": {
                    response = response.concat(responseArray[2][1]);
                    break;
                }
                case "S": {
                    response = response.concat(responseArray[2][2]);
                    break;
                }
                default: {
                    response = response.concat("Invalid Response\n");
                }
            }
            switch(responses[3]) {
                case "C": {
                    response = response.concat(responseArray[3][0]);
                    break;
                }
                case "T": {
                    response = response.concat(responseArray[3][1]);
                    break;
                }
                case "S": {
                    response = response.concat(responseArray[3][2]);
                    break;
                }
                case "O": {
                    response = response.concat(responseArray[3][3]);
                    break;
                }
                case "N": {
                    response = response.concat(responseArray[3][4]);
                    break;
                }
                default: {
                    response = response.concat("Invalid Response");
                }

            }                                
            System.out.println(String.format("\n\nHello %s, your age is %s\n%s",
                         responses[0], responses[1], response));
            System.out.println("Do you want to go again? (Y/N)");
            redo = scanner.next();
        } while (redo.compareToIgnoreCase("Y") == 0);
        
        int[] integerArray = new int[30];
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = i;
        }
        int j = 0;
        while(j < integerArray.length) {
            System.out.println(j++);
        }
        // ArrayList<Integer> intClassArray=  new ArrayList<>();
        // for(int i: integerArray) {
        //     intClassArray.add(new Integer(i));
        // }
        // intClassArray.forEach( (intObj) -> {
        //     System.out.println(intObj);
        // });
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = (i+1) * 2;
        }
        j = 29;
        while(j >= 0) {
            System.out.println(integerArray[j]);
            j--;
        }
        // for (int i = integerArray.length - 1; i >= 0; i--) {
        //     System.out.println(integerArray[i]);
        // }
        
        
        System.out.println(myMethod(10,integerArray));
    }

    public static int myMethod(int x, int[] array) {
        int sum = 0;
            for (int y: array) {
                
                if (y % 2 == 1){
                    System.out.println(y);
                } else {
                    sum += y;
                }
                if (y == x) {
                    break;
                }
            }
            return sum;
        }
        
}