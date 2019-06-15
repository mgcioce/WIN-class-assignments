package util;

public class InvalidInputException extends Exception{

    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "util.InvalidInputException: " + message;
    }
}
