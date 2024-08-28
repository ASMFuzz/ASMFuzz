import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_3045 {

    static String name = "?G0O71N\\eD";

    static byte[] data = {110,74,69,36,-125,93,-49,-30,61,60};

    static int level = 0;

    static int STRIDE = 1024;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3045().pass();
    }
}
