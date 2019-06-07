public class InvalidInputException extends Exception{

    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InvalidInputException: " + message;
    }
}
