import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_13291 {

    static String s = "mng*|rdPw0";

    static boolean debug = System.getProperty("debug") != null;

    static String name = "n\\?-QIj?@%";

    static byte[] data = {98,114,63,-115,50,-54,82,45,-41,84};

    static int level = 8;

    static int STRIDE = 1024;

    String debug(String s) {
        if (debug)
            System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13291().debug(s);
    }
}
