package util;

import wheel.WheelValues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class Util implements WheelValues {


    public static String[] parseWheelValues(String[][] wheel) throws InvalidInputException {
        ArrayList<String> valueList = new ArrayList<>();
        for (String[] element: wheel) {
            for (String e: element) {
                if (valueList.contains(e)) {
                    continue;
                } else {
                    boolean isValid = false;
                    for (String s: WheelValues.POSSIBLE_WHEEL_VALUES) {
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

    public static void bootstrapPuzzles() {
        Upload.uploadPuzzles();
    }

    public static class Upload {

        private static final String PUZZLE_DB = System.getProperty("user.dir") + "/puzzles.csv";

        public static ArrayList<String[]> puzzles = new ArrayList<>();

        private static void uploadPuzzles() {
            String next = null;
            String[] split = null;
            try{
                BufferedReader in = new BufferedReader(new FileReader(PUZZLE_DB));
                if (in.ready()){
                    do {
                        next = in.readLine();
                        if (Objects.isNull(next))
                            break;
                        split = next.split("\",\"");
                        for (int i = 0; i < split.length; i++) {
                            split[i] = split[i].replaceAll("\"","");
                        }
                        puzzles.add(split);
                    } while (true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
