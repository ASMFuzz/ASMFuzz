import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_14145 {

    static String s = "&YTCJ%@AWi";

    static boolean debug = System.getProperty("debug") != null;

    String debug(String s) {
        if (debug)
            System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14145().debug(s);
    }
}
