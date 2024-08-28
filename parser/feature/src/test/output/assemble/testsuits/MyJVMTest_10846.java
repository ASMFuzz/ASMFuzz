import java.io.*;
import java.util.*;

public class MyJVMTest_10846 {

    static String s = " Y@-^s08vu";

    static int errors = 0;

    static PrintWriter _pw = null;

    String log(String s) {
        errors++;
        _pw.println("ERROR:" + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10846().log(s);
    }
}
