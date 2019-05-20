public class Lambda {

    public static void main(String [] args) {
        System.out.println( () -> {
            return 2+1;
        }());
    }
}