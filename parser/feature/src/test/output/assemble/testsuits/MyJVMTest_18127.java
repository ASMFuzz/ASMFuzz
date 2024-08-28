import java.io.*;

public class MyJVMTest_18127 {

    static String testStr = "2dPGm$igE?";

    static byte[] expectBytes = { 53, 40, 54, 104, 72, -92, -58, -44, -41, -50 };

    static String csName = "1Y,yKC/`ie";

    static String MIXEDCONTENT = "JA\u3000\u3002\u0062\uFF64PAN" + "\uFF0C\uFF0E\u00A5\uFF65\uFF66X\u203E" + "\u30FB\uFF67\u203E";

    static byte[] repeatingEscapes = { (byte) 0x4a, (byte) 0x41, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x21, (byte) 0x21, (byte) 0x21, (byte) 0x23, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x62, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x0f, (byte) 0x0e, (byte) 0x0f, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x24, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x50, (byte) 0x41, (byte) 0x4e, (byte) 0x0e, (byte) 0x0f, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x21, (byte) 0x24, (byte) 0x21, (byte) 0x25, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x5c, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x25, (byte) 0x26, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x58, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x7e, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x21, (byte) 0x26, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x27, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x7e, (byte) 0x1b, (byte) 0x28, (byte) 0x42 };

    String roundTrip(String testStr, byte[] expectBytes, String csName) throws Exception {
        byte[] encodedBytes = testStr.getBytes(csName);
        if (encodedBytes.length != expectBytes.length) {
            throw new Exception(csName + " Encoder error");
        }
        for (int i = 0; i < expectBytes.length; i++) {
            if (encodedBytes[i] != expectBytes[i]) {
                throw new Exception(csName + " Encoder error");
            }
        }
        String decoded = new String(encodedBytes, csName);
        if (!decoded.equals(testStr)) {
            throw new Exception(csName + " Decoder error");
        }
        String decoded2 = new String(repeatingEscapes, csName);
        if (!decoded2.equals(MIXEDCONTENT)) {
            throw new Exception(csName + " Decoder error");
        }
        return csName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18127().roundTrip(testStr, expectBytes, csName);
    }
}
