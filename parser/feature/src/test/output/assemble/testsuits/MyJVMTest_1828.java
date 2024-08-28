import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_1828 {

    static String msg = "8nTuO9]HGC";

    static String name = "z&J[-%\\N\\&";

    static byte[] data = {-99,125,-119,32,13,-110,-13,-61,-39,-48};

    static int level = 6;

    static int STRIDE = 1024;

    static int passed = 0, failed = 0;

    String pass(String msg) {
        System.out.println(msg);
        passed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1828().pass(msg);
    }
}
