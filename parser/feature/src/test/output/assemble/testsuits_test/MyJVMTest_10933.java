import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_10933 {

    static String testStr = "uR0tX\\.|F#";

    static String expected = ">`lK,Vb+{b";

    String failureReport(String testStr, String expected) {
        System.err.println("Expected Characters:");
        for (int i = 0; i < expected.length(); i++) {
            System.out.println("expected char[" + i + "] : " + Integer.toHexString((int) expected.charAt(i)) + "  obtained char[" + i + "] : " + Integer.toHexString((int) testStr.charAt(i)));
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10933().failureReport(testStr, expected);
    }
}
