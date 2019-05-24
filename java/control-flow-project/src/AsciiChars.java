import java.util.Arrays;

public class AsciiChars {

    private static final String[] ASCII_NUMBERS_HEX = {"30","31","32","33","34","35","36","37","38","39"};
    private static final String[] ASCII_LOWER_CASE_HEX = {"61","62","63","64","65","66","67","68","69",
                                                            "6A","6B","6C","6D","6E","6F","70","71","72",
                                                            "73","74","75","76","77","78","79","7A"};
    private static final String[] ASCII_UPPER_CASE_HEX = {"41","42","43","44","45","46","47","48","49",
                                                            "4A","4B","4C","4D","4E","4F","50","51",
                                                            "52","53","54","55","56","57","58","59",
                                                            "5A"};
    public AsciiChars() {
        super();
    }

    public static void printNumbers()
    {
        String printOutput = "";
        for(String s: ASCII_NUMBERS_HEX) {
            printOutput = printOutput + s + " ";
        }
        System.out.println(printOutput);
    }

    public static void printLowerCase()
    {
        String printOutput = "";
        for(String s: ASCII_LOWER_CASE_HEX) {
            printOutput = printOutput + s + " ";
        }
        System.out.println(printOutput);
    }

    public static void printUpperCase()
    {
        String printOutput = "";
        for(String s: ASCII_UPPER_CASE_HEX) {
            printOutput = printOutput + s + " ";
        }
        System.out.println(printOutput);
    }

    public static String encodeString(String s) {
        byte[] numericEncoding = s.getBytes();
        int[] intSwitch = new int[numericEncoding.length];
        String[] hexEncoding = new String[intSwitch.length];
        for(int i = 0; i < intSwitch.length; i++) {
            intSwitch[i] = (int) numericEncoding[i];
            hexEncoding[i] = Integer.toHexString(intSwitch[i]);
        }
        String returnValue = Arrays.toString(hexEncoding).replaceAll("\\p{Punct}|\\s","");
        return returnValue;
    }

}
