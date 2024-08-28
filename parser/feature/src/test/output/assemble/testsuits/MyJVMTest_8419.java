import java.io.*;

public class MyJVMTest_8419 {

    static String msg = "9FYye7ilUU";

    static int errors = 0;

    String error(String msg) {
        System.err.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8419().error(msg);
    }
}
