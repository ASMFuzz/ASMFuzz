import java.io.*;
import java.util.*;

public class MyJVMTest_9465 {

    static String s = "ttK\"(<4iM%";

    void print(String s) {
        _pw.print(s);
    }

    static int errors = 0;

    static PrintWriter _pw = null;

    String lognoln(String s) {
        errors++;
        _pw.print(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9465().lognoln(s);
    }
}
