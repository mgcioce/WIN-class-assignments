public enum Puzzle {
    MOVIE_QUOTE("No - I am your father");

    private final String puzzle;
    private final String puzzleNoPunctuationLowerCase;

    Puzzle(String puzzle) {
        this.puzzle = puzzle;
        this.puzzleNoPunctuationLowerCase = puzzle.replaceAll("[^a-zA-Z]","").
                toLowerCase();
    }

    @Override
    public String toString() {
        return this.puzzle + "\n" + this.puzzleNoPunctuationLowerCase;
    }

    public String getPuzzleNoPunctuationLowerCase() {
        return this.puzzleNoPunctuationLowerCase;
    }

    public int getPuzzleLength() {
        return this.puzzleNoPunctuationLowerCase.length();
    }
}
