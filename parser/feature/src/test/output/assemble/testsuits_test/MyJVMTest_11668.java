import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_11668 {

    static String msg = "t|-W0-)6Uk";

    static int errors = 3;

    String error(String msg) {
        System.out.println("error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11668().error(msg);
    }
}
