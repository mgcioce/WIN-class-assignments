import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionDefinitionsTest {

    @Test
    public void spinWheelTest() {
        //1. null argument
        assertTrue(FunctionDefinitions.spinWheel(null).compareTo("ERROR") == 0);
        //2. empty array or array with null values;
        assertTrue(FunctionDefinitions.spinWheel(new String[1]).compareTo("ERROR") == 0);
        //3. return string
        String[] array = {"Test"};
        assertTrue(FunctionDefinitions.spinWheel(array).compareTo("Test") == 0);
    }
}