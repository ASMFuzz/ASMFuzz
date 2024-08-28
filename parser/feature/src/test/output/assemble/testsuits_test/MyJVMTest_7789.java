import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_7789 {

    static String expected = "M~dd=65pDN";

    static byte[] input = { -127, 13, -5, -95, -115, 91, 124, 77, 20, -33 };

    void failureReport(String testStr, String expected) {
        System.err.println("Expected Characters:");
        for (int i = 0; i < expected.length(); i++) {
            System.out.println("expected char[" + i + "] : " + Integer.toHexString((int) expected.charAt(i)) + "  obtained char[" + i + "] : " + Integer.toHexString((int) testStr.charAt(i)));
        }
    }

    static ByteBuffer bf = ByteBuffer.allocateDirect(1000);

    String testDecode(String expected, byte[] input) throws Exception {
        String out = new String(input, "utf8");
        if (!out.equals(expected)) {
            failureReport(out, expected);
            throw new Exception("UTF_8 Decoding test failed");
        }
        bf.clear();
        bf.put(input).flip();
        out = Charset.forName("UTF-8").decode(bf).toString();
        if (!out.equals(expected)) {
            failureReport(out, expected);
            throw new Exception("UTF_8 Decoding test failed(directbuffer)");
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7789().testDecode(expected, input);
    }
}
