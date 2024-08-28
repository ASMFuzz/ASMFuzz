import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_17750 {

    static String msg = "ulQE!j`u`?";

    static int passed = 0, failed = 0;

    String pass(String msg) {
        System.out.println(msg);
        passed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17750().pass(msg);
    }
}
