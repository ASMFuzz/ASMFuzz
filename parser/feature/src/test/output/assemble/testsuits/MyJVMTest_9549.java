import java.io.*;

public class MyJVMTest_9549 {

    static int start = -943514516;

    static int end = 1255185891;

    static char[] expectChars = { '+', 'c', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '^', '0', '0' };

    static String testName = "2(PxYFiGuH";

    byte[] checkRange(int start, int end, char[] expectChars, String testName) throws Exception {
        byte[] singleByte = new byte[1];
        byte[] encoded = new byte[1];
        int lookupOffset = 0;
        for (int i = start; i <= end; i++) {
            singleByte[0] = (byte) i;
            String unicodeStr = new String(singleByte, "ISCII91");
            if (unicodeStr.charAt(0) != expectChars[lookupOffset++]) {
                throw new Exception("Failed ISCII91 Regression Test");
            }
            encoded = unicodeStr.getBytes("ISCII");
        }
        return;
        return singleByte;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9549().checkRange(start, end, expectChars, testName);
    }
}
