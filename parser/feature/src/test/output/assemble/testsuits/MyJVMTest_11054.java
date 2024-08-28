import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_11054 {

    static String msg = ",2f3?B[rs$";

    static String name = "TgP`?=6wt2";

    static byte[] data = {-53,99,25,61,2,-34,-34,26,-27,-66};

    static int level = 0;

    static int STRIDE = 1024;

    static int passed = 0, failed = 0;

    String pass(String msg) {
        System.out.println(msg);
        passed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11054().pass(msg);
    }
}
