import java.io.*;
import java.util.*;

public class MyJVMTest_11204 {

    static String msg = "y(\"Pg$#3Zs";

    static int errorCount = 0;

    String error(String msg) {
        System.err.println(msg);
        errorCount++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11204().error(msg);
    }
}
