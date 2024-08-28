import java.io.*;
import java.util.*;

public class MyJVMTest_8895 {

    static String msg = "Vr\"#@}&Jv.";

    static int errorCount = 8;

    String error(String msg) {
        System.err.println(msg);
        errorCount++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8895().error(msg);
    }
}
