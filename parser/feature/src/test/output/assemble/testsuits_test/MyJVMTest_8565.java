import java.io.*;
import java.util.*;

public class MyJVMTest_8565 {

    static String msg = "hI|/c}?kc:";

    static String opt = "35lEFyaA*b";

    static int errors = -818346641;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8565().error(msg);
    }
}
