import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();
        Scanner kb = new Scanner(System.in);
        outputName(kb);
        powerballNumberGenerator(kb);
    }

    public static void outputName(Scanner kb) {
        do {
            System.out.println("Please enter your name and I'll encode it");
            String name = kb.nextLine();
            String encodedName = AsciiChars.encodeString(name);
            System.out.println(String.format("Hello %s - or should I say, %s!!!",name,encodedName));
            System.out.println("Do you want to go again? (Y/N)");
        } while(kb.nextLine().compareToIgnoreCase("Y") == 0);
    }

    public static void powerballNumberGenerator(Scanner kb) {
        String[] prompts = {"Hey! I'm gonna help you pick your next WINNING powerball numbers!\n" +
                "enter c to continue",
                "Question 1: How old are you?\n",
                "Question 2: What is your favorite animal?\n",
                "Question 3: What is the jersey number of your favorite athlete?\n",
                "Question 4: In what year were you born?\n",
                "Question 5: what is your favorite color?\n",
                "Question 6: What is your lucky number?\n",
                "Ok! Let me calculate your WINNING numbers!"};
        String[] responses = new String[prompts.length - 2];

        do {

            for (int i = 0; i < prompts.length; i++) {
                System.out.println(prompts[i]);
                if (i == 0) {
                    kb.nextLine();
                }
                if (i > 0 && i < prompts.length - 1) {
                    boolean good;
                    do {
                        good = true;
                        responses[i - 1] = kb.nextLine();
                        if (i != 2 && i != 5) {
                            try {
                                int check = Integer.parseInt(responses[i-1]);
                            } catch (Exception e) {
                                System.out.println("Please enter a number");
                                good = false;
                            }
                        } else { // i is either 2 or 5
                            try {
                                int check = Integer.parseInt(responses[i-1]);
                                System.out.println("Please enter a word or words");
                                good = false;
                            } catch (Exception e) {
                                break;
                            }
                        }
                    } while(!good);

                }
            }

            try{
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                System.out.println("Your WINNING numbers are: \n");
                for (int i = 0; i < responses.length; i++) {
                    if (i == 5) {
                        System.out.println(numberToNumber(responses[i],true));
                        continue;
                    }
                    if (i == 1 || i == 4) {
                        System.out.println(textToNumber(responses[i],false));
                    } else {
                        System.out.println(numberToNumber(responses[i],false));
                    }
                }
            }

            System.out.println("Would you like to generate a new set of numbers? (Y/N)");

        } while(kb.nextLine().compareToIgnoreCase("Y") == 0);
        System.out.println("\nGoodbye!");
    }

    public static int textToNumber(String text,boolean isPowerBall) {
        int returnValue = 0;
        byte[] numbers = text.getBytes();
        for(int i = 0; i < numbers.length; i++) {
            returnValue = returnValue + (int) numbers[i];
        }
        if (isPowerBall) {
            return (returnValue % 26) + 1;
        } else {
            return (returnValue % 69) + 1;
        }

    }

    public static int numberToNumber(String num,boolean isPowerBall) {
        int returnValue = 0;
        returnValue = Integer.parseInt(num);
        if (isPowerBall) {
            return (returnValue % 26) + 1;
        } else {
            return (returnValue % 69) + 1;
        }
    }
}
