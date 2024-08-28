import java.io.*;

public class MyJVMTest_18003 {

    static String msg = "ie)r_mgU5p";

    static int errors = 0;

    String error(String msg) {
        System.err.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18003().error(msg);
    }
}
