import java.io.*;
import java.nio.charset.*;

public class MyJVMTest_13046 {

    static String name = "ANi\"}jVdwF";

    static String testStr = "rh~DZ[rxOJ";

    static byte[] expectBytes = { 120, -122, -7, -36, 75, -4, 81, -109, 48, 63 };

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
        new MyJVMTest_13046().roundTrip(name, testStr, expectBytes);
    }
}
