import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_6947 {

    static String msg = "n)L&<n/-k{";

    static File file = null;

    static int errors = 0;

    String error(String msg) {
        System.err.println("Error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6947().error(msg);
    }
}
