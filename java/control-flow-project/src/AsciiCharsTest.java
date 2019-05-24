import static org.junit.Assert.*;

public class AsciiCharsTest {

    @org.junit.Test
    public void encodeString() {
        String hexEncoding = "626565";
        String convertedString = "";
        String next;
        for (int i = 0; i < hexEncoding.length();i+= 2) {
            next = hexEncoding.substring(i,i+2);
            convertedString = convertedString + (char) Integer.parseInt(next,16);
        }
        String result = AsciiChars.encodeString(convertedString);
        assertTrue(hexEncoding.compareTo(result) == 0);
    }
}