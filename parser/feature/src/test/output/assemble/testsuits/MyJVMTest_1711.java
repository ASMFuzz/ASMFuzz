import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_1711 {

    static String testStr = "iow$9_Iww|";

    static String expected = "xAmIfl~fL#";

    String failureReport(String testStr, String expected) {
        System.err.println("Expected Characters:");
        for (int i = 0; i < expected.length(); i++) {
            System.out.println("expected char[" + i + "] : " + Integer.toHexString((int) expected.charAt(i)) + "  obtained char[" + i + "] : " + Integer.toHexString((int) testStr.charAt(i)));
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1711().failureReport(testStr, expected);
    }
}
