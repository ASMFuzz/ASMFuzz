import java.io.*;
import java.util.*;

public class MyJVMTest_1624 {

    static String s = "&Bm:i[9{#,";

    static int errors = 0;

    static PrintWriter _pw = null;

    String log(String s) {
        errors++;
        _pw.println("ERROR:" + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1624().log(s);
    }
}
