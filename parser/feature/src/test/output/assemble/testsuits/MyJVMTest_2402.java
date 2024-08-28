import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_2402 {

    static String msg = "1h!@dHmR8+";

    static int errors = -1782965170;

    String error(String msg) {
        System.out.println("error: " + msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2402().error(msg);
    }
}
