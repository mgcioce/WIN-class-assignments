package contestant;

import game.Position;

public class Contestant {

    private String name;
    private boolean contestantsTurn;
    private int roundEarnings;
    private int totalEarnings;
    private boolean canWinMillion;
    private Position position;
    private String currentGuess;
    private boolean guessInPuzzle;
//    private boolean human;

    public Contestant(String name, Position position) {
        this.name = name;
        this.position = position;
//        this.human = human;
        this.contestantsTurn = false;
        this.roundEarnings = 0;
        this.totalEarnings = 0;
        this.canWinMillion = false;
        this.currentGuess = null;
        this.guessInPuzzle = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContestantsTurn() {
        return contestantsTurn;
    }

    public void setContestantsTurn(boolean contestantsTurn) {
        this.contestantsTurn = contestantsTurn;
    }

    public int getRoundEarnings() {
        return roundEarnings;
    }

    public void setRoundEarnings(int roundEarnings) {
        this.roundEarnings = roundEarnings;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public boolean canWinMillion() {
        return canWinMillion;
    }

    public void setCanWinMillion(boolean canWinMillion) {
        this.canWinMillion = canWinMillion;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

//    public boolean isHuman() {
//        return human;
//    }
//
//    public void setHuman(boolean human) {
//        this.human = human;
//    }


    public String getCurrentGuess() {
        return currentGuess;
    }

    public void setCurrentGuess(String currentGuess) {
        this.currentGuess = currentGuess;
    }

    public boolean isGuessInPuzzle() {
        return guessInPuzzle;
    }

    public void setGuessInPuzzle(boolean guessInPuzzle) {
        this.guessInPuzzle = guessInPuzzle;
    }

    @Override
    public String toString() {
        return this.name + " has $" + this.roundEarnings + " this round.";
    }
}
