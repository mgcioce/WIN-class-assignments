import java.util.*;

public class Practice {

    public static void main(String[] args) {
        String a = new String("Hello");
        String b = a;
        b = b.replace("H","'");
        System.out.println(b + "\n" + a);
    }

    
}