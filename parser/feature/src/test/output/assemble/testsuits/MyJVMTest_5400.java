import java.io.*;
import java.net.*;

public class MyJVMTest_5400 {

    static Class c = null;

    static String actual = "!Z5R'moB{\\";

    static int thread_id = -1081501647;

    String checkTransformationString(Class c, String actual) throws Exception {
        String expected = "class-transform-check: this-has-been--transformed";
        if (!actual.equals(expected)) {
            String msg1 = "Transformation failed for class" + c.getName();
            String msg2 = String.format("Expected: %s, actual: %s", expected, actual);
            throw new RuntimeException(msg1 + "\n" + msg2);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5400().checkTransformationString(c, actual);
    }
}
