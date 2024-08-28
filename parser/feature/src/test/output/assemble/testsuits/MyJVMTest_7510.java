import java.io.*;
import java.util.*;

public class MyJVMTest_7510 {

    static String msg = "PAf(X^b{jZ";

    static int errors = 0;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7510().error(msg);
    }
}
