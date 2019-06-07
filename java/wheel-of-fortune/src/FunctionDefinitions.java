
import java.util.Random;

public class FunctionDefinitions {

    public static String spinWheel(String[] wheel) {
        Random random = new Random();
        String returnString = wheel[random.nextInt(wheel.length)];
        return returnString;
    }

    public static boolean checkGuess(String guess, Puzzle puzzle) throws InvalidInputException {
        if (guess.matches("[^a-zA-Z]")) {
            throw new InvalidInputException("enter an english alphabet character");
        }
        if (guess.length() > 1) {
            throw new InvalidInputException("only enter one character to be checked");
        }
        guess = guess.toLowerCase();
        return puzzle.getPuzzleNoPunctuationLowerCase().contains(guess);
    }

    public static int numberOfOccurances(String guess, Puzzle puzzle) throws InvalidInputException {
        if (guess.matches("[^a-zA-Z]")) {
            throw new InvalidInputException("enter an english alphabet character");
        }
        if (guess.length() > 1) {
            throw new InvalidInputException("only enter one character to be checked");
        }
        guess = guess.toLowerCase();
        String solution = puzzle.getPuzzleNoPunctuationLowerCase();
        int num = 0;
        boolean isThere;
        int next = 0;
        do {
            isThere = false;
            int index = solution.indexOf(guess,next);
            if (index != -1) {
                next = index + 1;
                num++;
                isThere = true;
            }
        } while(isThere);

        return num;
    }

    public static int calculateChange(String guess,int num,
                                      String value,Puzzle puzzle,Wheel wheel)
                                        throws InvalidInputException {
        if (guess.matches("[^a-zA-Z]")) {
            throw new InvalidInputException("the guess must be an english alphabet character");
        }
        if (guess.length() > 1) {
            throw new InvalidInputException("the guess can only be one character long");
        }
        if (guess.compareTo("") == 0) {
            throw new InvalidInputException("The guess must be one character long");
        }
        guess = guess.toLowerCase();
        if (num < 0) {
            throw new InvalidInputException("the number of occurances must be >= 0");
        }
        if (num > puzzle.getPuzzleLength()) {
            throw new InvalidInputException("The number of occurances can't be higher than the" +
                                            " number of characters in the puzzle");
        }
        for (String s: wheel.)
    }

}
