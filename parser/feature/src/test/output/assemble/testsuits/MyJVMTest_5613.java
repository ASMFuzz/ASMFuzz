import java.io.*;

public class MyJVMTest_5613 {

    static String msg = ",@3h*J~|A$";

    void fail(String msg) {
        System.err.println("FAIL: " + msg);
        failed++;
    }

    static int failed = 57859591;

    String failWithIOE(String msg) throws IOException {
        fail(msg);
        throw new IOException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5613().failWithIOE(msg);
    }
}
