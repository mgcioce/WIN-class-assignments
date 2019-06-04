public class TrollBreaker {

    public static String disemvowel(String s) {
        try {
            s = s.replaceAll("a|A|e|E|i|I|o|O|u|U","");
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(disemvowel("This website is for losers LOL!"));
    }
}