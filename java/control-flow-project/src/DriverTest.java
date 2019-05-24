import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    @Test
    public void textToNumber() {
        String testString = "test";
        byte[] numericEnconding = testString.getBytes();
        int sum = 0;
        for (byte b: numericEnconding) {
            sum += (int)b;
        }
        int regular = sum % 69 + 1;
        int powerball = sum % 26 + 1;
        assertEquals(regular,Driver.textToNumber(testString,false));
        assertEquals(powerball, Driver.textToNumber(testString,true));
    }

    @Test
    public void numberToNumber() {
        String testNum = "70";
        long regular = (Integer.parseInt(testNum) % 69) + 1;
        long powerball = (Integer.parseInt(testNum) % 26) + 1;
        assertEquals(regular, Driver.numberToNumber(testNum,false));
        assertEquals(powerball, Driver.numberToNumber(testNum,true));
    }
}