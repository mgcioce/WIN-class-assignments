
import java.util.ArrayList;

public class Util implements WheelValues {


    public static String[] parseWheelValues(String[][] wheel) throws InvalidInputException {
        ArrayList<String> valueList = new ArrayList<>();
        for (String[] element: wheel) {
            for (String e: element) {
                if (valueList.contains(e)) {
                    continue;
                } else {
                    boolean isValid = false;
                    for (String s: POSSIBLE_WHEEL_VALUES) {
                        if (s.compareTo(e) == 0) {
                            isValid = true;
                            break;
                        }
                    }
                    if (isValid) {
                        valueList.add(e);
                    } else {
                        throw new InvalidInputException("This value is not a valid wheel value");
                    }

                }
            }
        }
        return valueList.toArray(new String[1]);
    }

}
