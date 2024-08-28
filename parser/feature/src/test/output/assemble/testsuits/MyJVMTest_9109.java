import java.io.*;

public class MyJVMTest_9109 {

    static String msg = ",8V4S!a@=[";

    static int errors = 0;

    String error(String msg) {
        System.err.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9109().error(msg);
    }
}
