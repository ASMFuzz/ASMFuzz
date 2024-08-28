import java.io.*;

public class MyJVMTest_8536 {

    static String testStr = "g-[8_^):xG";

    static byte[] expectBytes = { -104, -107, -117, -108, 95, 1, 41, 58, -64, 108 };

    static String csName = "B}m4^b{_}q";

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
        new MyJVMTest_8536().roundTrip(testStr, expectBytes, csName);
    }
}
