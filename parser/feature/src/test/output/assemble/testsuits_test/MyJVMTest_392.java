import java.io.*;

public class MyJVMTest_392 {

    static int start = 1464997978;

    static int end = 0;

    static char[] expectChars = { '{', Character.MIN_VALUE, '}', 'e', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '0' };

    static String testName = "4zUjEpywu.";

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
        new MyJVMTest_392().checkRange(start, end, expectChars, testName);
    }
}
