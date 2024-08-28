import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_16067 {

    static boolean isWindows = System.getProperty("os.name").startsWith("Windows");

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = 9223372036854775807L;

    static String osname = "v^\\yKw.2WV";

    boolean isWindows() {
        return osname.startsWith("Windows");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16067().isWindows());
    }
}
