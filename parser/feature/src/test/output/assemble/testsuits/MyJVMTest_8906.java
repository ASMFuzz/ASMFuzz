import java.io.*;
import java.lang.annotation.*;

public class MyJVMTest_8906 {

    static String msg = "^xPL?[f[=]";

    static int errors = 8;

    String error(String msg) {
        System.out.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8906().error(msg);
    }
}
