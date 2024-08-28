import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_690 {

    static char inputChar = 'U';

    static boolean expectedResult = false;

    static CharsetEncoder encoder = null;

    char canEncodeTest(char inputChar, boolean expectedResult) throws Exception {
        String msg = "err: Shift_JIS canEncode() return value ";
        if (encoder.canEncode(inputChar) != expectedResult) {
            throw new Exception(msg + !(expectedResult) + ": " + Integer.toHexString((int) inputChar));
        }
        return inputChar;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_690().canEncodeTest(inputChar, expectedResult);
    }
}
