import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_3943 {

    static String s = "l2;c>at7b\\";

    static boolean debug = System.getProperty("debug") != null;

    static String name = "n?v$[O`:u`";

    static byte[] data = {34,-62,-46,-46,42,-39,52,-21,86,67};

    static int level = 8;

    static int STRIDE = 1024;

    String debug(String s) {
        if (debug)
            System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3943().debug(s);
    }
}
