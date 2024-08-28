import java.io.*;

public class MyJVMTest_11921 {

    static String msg = "gff4atK]8I";

    static int failed = 8;

    String fail(String msg) {
        System.err.println("FAIL: " + msg);
        failed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11921().fail(msg);
    }
}
