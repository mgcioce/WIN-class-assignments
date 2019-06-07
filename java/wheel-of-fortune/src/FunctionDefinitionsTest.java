import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionDefinitionsTest {

    private String[] invalidCharacters = {"`","~","1","!","2","@","3","#","4","$","5","%","6","^",
            "7","&","8","*","9","(","0",")","-","_","=","+","[",
            "{","]","}","\\","|",";",":","'","\"",",","<",".",">",
            "/","?"};

    //spinWheel()
    @Test(expected = NullPointerException.class)
    public void spinWheelTest() {
        //1. null argument
        FunctionDefinitions.spinWheel(null);
        //2. empty array or array with null values;
        FunctionDefinitions.spinWheel(new String[1]);
        //3. return string
        String[] array = {"Test"};
        assertTrue(FunctionDefinitions.spinWheel(array).compareTo("Test") == 0);
    }

    //checkGuess()
    @Test(expected = NullPointerException.class)
    public void checkGuessTestNullPointer() throws InvalidInputException {
        //1. null argument
            FunctionDefinitions.checkGuess(null, Puzzle.MOVIE_QUOTE);
            FunctionDefinitions.checkGuess("a",null);
            FunctionDefinitions.checkGuess(null,null);

    }

    @Test(expected = InvalidInputException.class)
    public void checkGuessInvalidInput() throws InvalidInputException {
        //1. non-english alphabet character

        for (String s: invalidCharacters) {
            FunctionDefinitions.checkGuess(s, Puzzle.MOVIE_QUOTE);
        }
        //2. more than one character
        FunctionDefinitions.checkGuess("aa", Puzzle.MOVIE_QUOTE);
    }

    @Test
    public void checkGuessTest() throws InvalidInputException {
        assertTrue(FunctionDefinitions.checkGuess("i", Puzzle.MOVIE_QUOTE));
    }

    //numberOfOccurances()
    @Test(expected = NullPointerException.class)
    public void numberOfOccurancesNullPointer() throws InvalidInputException{
        FunctionDefinitions.numberOfOccurances(null,Puzzle.MOVIE_QUOTE);
        FunctionDefinitions.numberOfOccurances("a",null);
        FunctionDefinitions.numberOfOccurances(null,null);
    }

    @Test(expected = InvalidInputException.class)
    public void numberOfOccurancesInvalidInput() throws InvalidInputException {
        for (String s: invalidCharacters) {
            FunctionDefinitions.numberOfOccurances(s, Puzzle.MOVIE_QUOTE);
        }
        FunctionDefinitions.numberOfOccurances("aa",Puzzle.MOVIE_QUOTE);
    }

    @Test
    public void numberOfOccurancesTest() {
        try{
            assertEquals(1,(long) FunctionDefinitions.numberOfOccurances("i",
                    Puzzle.MOVIE_QUOTE));
            assertEquals(2,(long) FunctionDefinitions.numberOfOccurances("o",
                    Puzzle.MOVIE_QUOTE));
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    //calculateChange()
    @Test(expected = NullPointerException.class)
    public void calculateChangeNullPointer() throws InvalidInputException {
        String guess;
        String value;
        Puzzle puzzle;
        Wheel wheel;
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                wheel = null;
            } else {
                wheel = Wheel.ROUND_ONE;
            }
            if ( (i / 2) % 2 == 0) {
                puzzle = null;
            } else {
                puzzle = Puzzle.MOVIE_QUOTE;
            }
            if ( (i / 4) % 2 == 0) {
                value = null;
            } else {
                value = "500";
            }
            if ( (i / 8) % 2 == 0) {
                guess = null;
            } else {
                guess = "i";
            }
            FunctionDefinitions.calculateChange(guess,1,value,puzzle,wheel);
        }
    }

    @Test(expected = InvalidInputException.class)
    public void calculateChangeInvalidInput() throws InvalidInputException {
        String guess = null;
        int num = 0;
        String value = null;
        Puzzle puzzle = Puzzle.MOVIE_QUOTE;
        Wheel wheel = Wheel.ROUND_ONE;
        for (int g = 0; g < 4; g++) {

            switch(g) {
                case 1: {
                    guess = "i";
                    break;
                }
                case 2: {
                    guess = "aa";
                    break;
                }
                case 3: {
                    guess = "";
                }
            }

            for (int n = 0; n < 4; n++) {

                switch(n) {
                    case 0: {
                        num = -1;
                        break;
                    }
                    case 1: {
                        num = 0;
                        break;
                    }
                    case 2: {
                        num = 1;
                        break;
                    }
                    case 3: {
                        num = 1000;
                    }
                }

                for (int v = 0; v < 4; v++) {

                    switch(v) {
                        case 0: {
                            value = "NOTONWHEEL";
                            break;
                        }
                        case 1: {
                            value = "Bankrupt";
                            break;
                        }
                        case 2: {
                            value = "Lose a Turn";
                            break;
                        }
                        case 3: {
                            value = "500";
                        }
                    }

                    if (g == 0) {
                        for (String s: invalidCharacters) {
                            guess = s;
                            FunctionDefinitions.calculateChange(guess,num,value,puzzle,wheel);
                        }
                    } else {
                        if ( (g == 1) && (n == 2) && (v == 1 || v == 2 || v == 3)) {
                            continue;
                        } else {
                            FunctionDefinitions.calculateChange(guess,num,value,puzzle,wheel);
                        }

                    }
                }
            }
        }
    }

    @Test
    public void calculateChangeTest() {
        String[] guesses = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".split("");
        String[] wheelValues = {"Bankrupt","2500","500","600","700","650","1000000","550","800",
                                "Lose a Turn","900"};
        String guess = null;
        String value = null;
        try{
            for (int g = 0; g < guesses.length; g++) {
                guess = guesses[g];
                for (int v = 0; v < wheelValues.length; v++) {
                    value = wheelValues[v];
                    FunctionDefinitions.calculateChange(guess,
                                        FunctionDefinitions.numberOfOccurances(guess,Puzzle.MOVIE_QUOTE),
                                        value,Puzzle.MOVIE_QUOTE,Wheel.ROUND_ONE);
                }
            }
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

}