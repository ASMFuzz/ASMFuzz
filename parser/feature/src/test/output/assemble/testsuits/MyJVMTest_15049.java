import java.io.*;

public class MyJVMTest_15049 {

    static String msg = "(3k[~45@JX";

    void fail(String msg) {
        System.err.println("FAIL: " + msg);
        failed++;
    }

    static int failed = 0;

    String failWithIOE(String msg) throws IOException {
        fail(msg);
        throw new IOException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15049().failWithIOE(msg);
    }
}
