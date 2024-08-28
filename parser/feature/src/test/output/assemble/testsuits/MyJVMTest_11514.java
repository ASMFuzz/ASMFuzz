import java.io.*;

public class MyJVMTest_11514 {

    static int start = 9;

    static int end = 8;

    static String testName = "Rh?QaZl!qu";

    byte[] checkUnmapped(int start, int end, String testName) throws Exception {
        byte[] singleByte = new byte[1];
        for (int i = start; i <= end; i++) {
            singleByte[0] = (byte) i;
            try {
                String unicodeStr = new String(singleByte, "ISCII91");
                if (unicodeStr.charAt(0) != '\uFFFD') {
                    System.err.println("FAILED " + testName + "input byte is " + i);
                    throw new Exception("Failed ISCII91 regression test");
                }
            } catch (UnsupportedEncodingException e) {
                System.err.println("Unsupported character encoding");
            }
        }
        return;
        return singleByte;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11514().checkUnmapped(start, end, testName);
    }
}
