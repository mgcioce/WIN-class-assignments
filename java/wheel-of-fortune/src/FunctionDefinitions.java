import java.util.Objects;
import java.util.Random;

public class FunctionDefinitions {

    public static String spinWheel(String[] wheel) {
        if (Objects.isNull(wheel))
            return "ERROR";
        Random random = new Random();
        String returnString = wheel[random.nextInt(wheel.length)];
        if (Objects.isNull(returnString))
            return "ERROR";
        return returnString;
    }
}
