import java.io.*;

public class MyJVMTest_9313 {

    static int start = 9;

    static int end = 8;

    static String testName = "!0;n6zY*Rb";

    void failureReport() {
        System.err.println("Failed ISCII91 Regression Test");
    }

    byte[] mapEquiv(int start, int end, String testName) throws Exception {
        byte[] singleByte = new byte[1];
        byte[] encoded = new byte[1];
        for (int i = start; i <= end; i++) {
            singleByte[0] = (byte) i;
            try {
                String unicodeStr = new String(singleByte, "ISCII91");
                if (i != (int) unicodeStr.charAt(0)) {
                    System.err.println("FAILED ISCII91 Regression test" + "input byte is " + i);
                    throw new Exception("");
                }
                encoded = unicodeStr.getBytes("ISCII91");
                if (encoded[0] != singleByte[0]) {
                    System.err.println("Encoding error " + testName);
                    throw new Exception("Failed ISCII91 Regression test");
                }
            } catch (UnsupportedEncodingException e) {
                failureReport();
            }
        }
        return;
        return singleByte;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9313().mapEquiv(start, end, testName);
    }
}
