import java.io.*;

public class MyJVMTest_2639 {

    static String msg = "#-<Y8+2|'T";

    static int failed = 0;

    String fail(String msg) {
        System.err.println("FAIL: " + msg);
        failed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2639().fail(msg);
    }
}
