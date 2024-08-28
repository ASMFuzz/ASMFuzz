import java.io.*;
import java.util.*;

public class MyJVMTest_17049 {

    static String msg = "*+#'ZX;%U1";

    static int errors = 0;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17049().error(msg);
    }
}
