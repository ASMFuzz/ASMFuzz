import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_10782 {

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = -9223372036854775808L;

    static String osname = "lW6{guuQ@k";

    boolean isLinux() {
        return osname.equals("Linux");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10782().isLinux());
    }
}
