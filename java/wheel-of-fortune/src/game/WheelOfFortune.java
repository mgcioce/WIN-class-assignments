package game;

import contestant.Contestant;
import puzzle.Puzzle;
import util.InvalidInputException;
import util.Quit;
import util.Util;
import wheel.Wheel;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortune {

    private ArrayList<Contestant> contestants;
    private ArrayList<Wheel> wheels;
    private ArrayList<Puzzle> puzzles;
    private int round;

    public WheelOfFortune() {
        this.contestants = null;
        this.wheels = new ArrayList<>();
        this.puzzles = new ArrayList<>();
        this.round = 0;
    };

    public ArrayList<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(ArrayList<Wheel> wheel) {
        this.wheels = wheel;
    }

    public void setWheel(Wheel wheel, int round) {
        this.wheels.add(round - 1,wheel);
    }

    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    public void setPuzzles(ArrayList<Puzzle> puzzle) {
        this.puzzles = puzzle;
    }

    public void setPuzzle(Puzzle puzzle, int round) {
        this.puzzles.add(round - 1,puzzle);
    }

    private int getStartingPosition() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private Contestant nextPlayer(int i) {
        return this.contestants.get(i % 3);
    }

    private void modifyAccount(Contestant contestant, int modValue) throws InvalidInputException {
        if (!contestant.isContestantsTurn()) {
            throw new InvalidInputException("it is not this contestants turn");
        }
        if (Objects.isNull(contestant.getName()) || Objects.isNull(contestant.getPosition())) {
            throw new InvalidInputException("This contestant is not created correctly");
        }
        if (modValue < -250 || (modValue > -250 && modValue < 0) ||
                (modValue > 0 && modValue < 500)) {
            throw new InvalidInputException("the mod value is not valid");
        }
        int testValue;
        boolean valid = false;
        for (String s: Util.POSSIBLE_WHEEL_VALUES) {
            if (s.compareTo("Bankrupt") == 0 || s.compareTo("Lose a Turn") == 0 ||
                    s.compareTo("1000000") == 0) {
                continue;
            } else {
                testValue = Integer.parseInt(s);
            }
            if (modValue == 0) {
                valid = true;
                break;
            }
            if ((modValue % testValue) == 0) {
                valid = true;
                break;
            }
            if (modValue == -250) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new InvalidInputException("the mod value is not valid");
        }
        contestant.setRoundEarnings(contestant.getRoundEarnings() + modValue);
    }

    private boolean checkGuess(String guess, Puzzle puzzle) throws InvalidInputException {
        if (guess.matches("[^a-zA-Z]")) {
            throw new InvalidInputException("enter an english alphabet character");
        }
        if (guess.length() > 1) {
            throw new InvalidInputException("only enter one character to be checked");
        }
        guess = guess.toLowerCase();
        if (puzzle.getPuzzleNoPunctuationLowerCase().contains(guess) &&
                !(puzzle.alreadyGuessed(guess))) {
            return true;
        } else {
            return false;
        }
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

    public static int calculateChange(String guess, int num,
                                      String value, Puzzle puzzle, Wheel wheel)
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
        boolean isValid = false;
        for (String s: wheel.getWheelValues()) {
            if (s.compareTo(value) == 0) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new InvalidInputException("The value does not appear on the designate wheel");
        }

        //actual function
        boolean isVowel = false;
        String[] vowels = {"a","e","i","o","u"};
        for (String vowel: vowels) {
            if (vowel.compareTo(guess) == 0) {
                isVowel = true;
                break;
            }
        }
        if (isVowel) {
            return -250;
        } else { //it's a consonant

            try{
                if (value.compareTo("1000000") == 0)
                    return 0;
                else {
                    return Integer.parseInt(value) * num;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }

    }

    private boolean playerTurn(Contestant player, Puzzle puzzle, Wheel wheel, Quit quit) {
        Scanner kb = new Scanner(System.in);
        boolean inControl = false;
        do {
            String value = wheel.spinWheel();
            System.out.println(puzzle.viewPuzzle());
            System.out.println("Used letters: " + puzzle.getLettersGuessed());
            inControl = false;
            System.out.println(player.toString());

            System.out.println("\n\t1.Buy a vowel\n\t2.Spin the wheel\n\t" +
                    "3.Solve the puzzle\n\t0.Quit game\n\nEnter 1,2,3, or 0: ");
            String guess = null;
            String optionString = kb.nextLine();
            while(optionString.matches("[^1230]") || optionString.length() > 1 ||
                    optionString.compareTo("") == 0 ||
                    (optionString.compareTo("1") == 0 && player.getRoundEarnings() < 250)) {

                if (optionString.matches("[^1230]") || optionString.length() > 1 ||
                        optionString.compareTo("") == 0 ) {
                    System.out.println("Sorry, you need to enter either 1,2,3, or 0");
                } else {
                    System.out.println("Sorry: you don't have enough money to buy a vowel");
                }
                System.out.println("\n\t1.Buy a vowel\n\t2.Spin the wheel\n\t" +
                        "3.Solve the puzzle\n\t0.Quit game\n\nEnter 1,2,3, or 0: ");
                optionString = kb.nextLine();
            }
            int option = Integer.parseInt(optionString);

            switch(option) {
                case 1: {
                    System.out.println(puzzle.viewPuzzle() + "\n\nEnter a vowel (a,e,i,o,u)");
                    System.out.println("Used letters: " + puzzle.getLettersGuessed());
                    guess = kb.nextLine();
                    while(!guess.matches("[aeiouAEIOU]")) {
                        System.out.println("Sorry - not a vowel: try again");
                        guess = kb.nextLine();
                    }
                    try {
                        puzzle.addGuess(guess);
                        if (checkGuess(guess,puzzle)) {
                            int numOfOccurances = numberOfOccurances(guess,puzzle);
                            if (numOfOccurances > 1) {
                                System.out.println("There are " + numOfOccurances + " " + guess + "s");
                            } else {
                                System.out.println("There is " + numOfOccurances + " " + guess);
                            }
                            puzzle.addCorrectGuess(guess);
                            modifyAccount(player,-250);
                            inControl = true;
                        } else {
                            System.out.println("Sorry: there are no " + guess + "'s in the puzzle");
                            modifyAccount(player,-250);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                }
                case 2: {


                    if (value.compareTo("Bankrupt") == 0) {
                        System.out.println("You hit Bankrupt! :(");
                        try{
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        player.setRoundEarnings(0);
                        return false;
                    }
                    if (value.compareTo("Lose a Turn") == 0) {
                        System.out.println("Lose a Turn!");
                        try{
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                    System.out.println("$" + value);
                    System.out.println(puzzle.viewPuzzle() + "\n\nenter a consonant");
                    System.out.println("Used letters: " + puzzle.getLettersGuessed());
                    guess = kb.nextLine();
                    while(!guess.matches("[^aeiouAEIOU\\W]")) {
                        System.out.println("Sorry - not a consonant: try again");
                        guess = kb.nextLine();
                    }
                    try {
                        puzzle.addGuess(guess);
                        if (checkGuess(guess,puzzle)) {
                            if (value.compareTo("1000000") == 0) {
                                player.setCanWinMillion(true);
                                System.out.println("Congrats! you're not done yet though. Win the " +
                                        "game to win ONE MILLION DOLLARS!");
                            }
                            int numOfOccurances = numberOfOccurances(guess,puzzle);
                            if (numOfOccurances > 1) {
                                System.out.println("There are " + numOfOccurances + " " + guess + "'s");
                            } else {
                                System.out.println("There is " + numOfOccurances + " " + guess);
                            }
                            puzzle.addCorrectGuess(guess);
                            int modValue = calculateChange(guess,numOfOccurances,
                                    value,puzzle,wheel);
                            modifyAccount(player,modValue);
                            inControl = true;
                        } else {
                            System.out.println("Sorry: there are no " + guess + "'s in the puzzle");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    break;
                }
                case 3: {

                    System.out.println(puzzle.viewPuzzle() + "\n\nGo ahead and solve the puzzle: ");
                    System.out.println("Used letters: " + puzzle.getLettersGuessed());
                    guess = kb.nextLine();
                    guess = guess.replaceAll("[^a-zA-Z]","").toLowerCase();
                    if (guess.compareTo(puzzle.getPuzzleNoPunctuationLowerCase()) == 0) {
                        System.out.println("That's it!\n\n" + puzzle.toString());
                        try {
                            modifyAccount(player,1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    } else {
                        System.out.println("Sorry - that's not it!");
                    }
                    break;
                }
                default: {
                    quit.setQuit(true);
                }
            }
        } while(inControl);
        return false;
    }

    private boolean playRound(Puzzle puzzle, Wheel wheel) {
        Quit quit;
        int i = getStartingPosition();
        Contestant nextPlayer = null;
        boolean solved = false;
        do {
            quit = new Quit(false);
            nextPlayer = this.contestants.get(i++ % 3);
            nextPlayer.setContestantsTurn(true);
            solved = playerTurn(nextPlayer, puzzle, wheel, quit);
            nextPlayer.setContestantsTurn(false);
            if (quit.getQuit()) {
                System.out.println("Exit");
                return false;
            }
        } while(!solved);
        return solved;
    }

    public boolean play() {
        boolean playAgain = false;
        boolean quit = false;
        for (int i = 0; i < this.puzzles.size(); i++) {
            quit = playRound(this.puzzles.get(i),this.wheels.get(i));
            if (!quit) {
                return false;
            }
            System.out.println("At the end of round " + (i+1));
            for (Contestant c: this.contestants) {
                c.setTotalEarnings(c.getRoundEarnings() + c.getTotalEarnings());
                c.setRoundEarnings(0);
                System.out.println(c.getName() + " has $" + c.getTotalEarnings());
            }
            try{
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Contestant next = null;
        Contestant winner = null;
        for (int i = 0; i < this.contestants.size(); i++) {
            if (i == 0){
                winner = this.contestants.get(i);
                continue;
            }
            next = this.contestants.get(i);
            if (next.getTotalEarnings() > winner.getTotalEarnings()) {
                winner = next;
            }
        }
        if (!winner.canWinMillion()) {
            System.out.println(winner.getName() + " has won $" + winner.getTotalEarnings());
        } else {
            System.out.println("YOU JUST ONE A MILLION DOLLARS!!!!");
        }


        return playAgain;
    }

    public static void main(String[] args) {
        Util.bootstrapPuzzles();
        WheelOfFortune game = new WheelOfFortune();
        game.setContestants(populateContestants());
        game.setWheel(Wheel.ROUND_ONE,1);
        game.setWheel(Wheel.ROUND_ONE,2);
        game.setWheel(Wheel.ROUND_ONE,3);
        game.setPuzzle(new Puzzle(Util.Upload.puzzles.get(0)[0],Util.Upload.puzzles.get(0)[1]),1);
        game.setPuzzle(new Puzzle(Util.Upload.puzzles.get(1)[0],Util.Upload.puzzles.get(1)[1]),2);
        game.setPuzzle(new Puzzle(Util.Upload.puzzles.get(2)[0],Util.Upload.puzzles.get(2)[1]),3);
        game.play();
    }

    private static ArrayList<Contestant> populateContestants() {
        ArrayList<Contestant> contestants = new ArrayList<>();
        Scanner kb = new Scanner(System.in);
        String response = null;
        Position position = null;
        for (int i = 0; i < 3; i++) {
            System.out.println("Our next contestant is:\n\t name: ");
            response = kb.nextLine();
            switch(i) {
                case 0: {
                    position = Position.LEFT;
                    break;
                }
                case 1: {
                    position = Position.MIDDLE;
                    break;
                }
                case 2: {
                    position = Position.RIGHT;
                }
            }
            contestants.add(new Contestant(response,position));
        }
        return contestants;
    }
}
