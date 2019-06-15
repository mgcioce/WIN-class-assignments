package puzzle;

import util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class Puzzle {




    private final String puzzle;
    private final String puzzleNoPunctuationLowerCase;
    private final ArrayList<String> correctGuesses;
    private final String clue;
    private final ArrayList<String> guessedLetters;

    public Puzzle(String puzzle, String clue) {
        this.puzzle = puzzle;
        this.puzzleNoPunctuationLowerCase = puzzle.replaceAll("[^a-zA-Z]","").
                toLowerCase();
        this.correctGuesses = new ArrayList<>();
        this.clue = clue;
        this.guessedLetters = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.puzzle;
    }

    public String getPuzzleNoPunctuationLowerCase() {
        return this.puzzleNoPunctuationLowerCase;
    }

    public int getPuzzleLength() {
        return this.puzzleNoPunctuationLowerCase.length();
    }

    public void addCorrectGuess(String guess) {
        this.correctGuesses.add(guess.toLowerCase());
        this.correctGuesses.add(guess.toUpperCase());
    }

    public boolean addGuess(String guess) {
        guess = guess.toLowerCase();
        if (!this.guessedLetters.contains(guess)) {
            this.guessedLetters.add(guess);
            return true;
        } else {
            return false;
        }
    }

    public boolean alreadyGuessed(String guess) {
        if (this.correctGuesses.contains(guess.toLowerCase()) ||
                this.correctGuesses.contains(guess.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    public String viewPuzzle() {
        String copy = this.puzzle;
        String next = null;
        for (int i = 0; i < copy.length(); i++) {
            next = copy.substring(i,i+1);
            if (next.matches("[^a-zA-Z]")) {
                continue;
            }
            if (!this.correctGuesses.contains(next)) {
                copy = copy.replace(next,"_");
            }
        }
        return this.clue + ":\n" + copy;
    }

    public String getLettersGuessed() {
        String returnString = "";
        for (String s: this.guessedLetters) {
            returnString += s;
        }
        return returnString;
    }


}
