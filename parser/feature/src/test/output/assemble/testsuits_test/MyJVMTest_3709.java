import java.io.*;
import java.nio.charset.*;

public class MyJVMTest_3709 {

    static String name = "^`)_est8L%";

    static String testStr = "wjX:g6 3vN";

    static byte[] expectBytes = { -57, 59, 27, -46, -56, -81, -103, 79, -1, 76 };

    static String MIXEDCONTENT = "JA\u3000\u3002\u0062\uFF64PAN" + "\uFF0C\uFF0E\u00A5\uFF65\uFF66X\u203E" + "\u30FB\uFF67\u203E";

    static byte[] repeatingEscapes = { (byte) 0x4a, (byte) 0x41, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x21, (byte) 0x21, (byte) 0x21, (byte) 0x23, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x62, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x0f, (byte) 0x0e, (byte) 0x0f, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x24, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x50, (byte) 0x41, (byte) 0x4e, (byte) 0x0e, (byte) 0x0f, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x21, (byte) 0x24, (byte) 0x21, (byte) 0x25, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x5c, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x25, (byte) 0x26, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x58, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x7e, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x21, (byte) 0x26, (byte) 0x1b, (byte) 0x28, (byte) 0x49, (byte) 0x27, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x7e, (byte) 0x1b, (byte) 0x28, (byte) 0x42 };

    String roundTrip(String name, String testStr, byte[] expectBytes) throws Exception {
        byte[] encodedBytes = testStr.getBytes(name);
        if (encodedBytes.length != expectBytes.length) {
            throw new Exception(name + " Encoder error");
        }
        for (int i = 0; i < expectBytes.length; i++) {
            if (encodedBytes[i] != expectBytes[i]) {
            }
        }
        String decoded = new String(encodedBytes, name);
        if (!decoded.equals(testStr)) {
            throw new Exception(name + " Decoder error");
        }
        String decoded2 = new String(repeatingEscapes, name);
        if (!decoded2.equals(MIXEDCONTENT)) {
            throw new Exception(name + " Decoder error");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3709().roundTrip(name, testStr, expectBytes);
    }
}
