import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_4747 {

    static String s = "Fr!Z8.0bFp";

    static boolean debug = System.getProperty("debug") != null;

    String debug(String s) {
        if (debug)
            System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4747().debug(s);
    }
}
