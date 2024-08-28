import java.io.*;
import java.util.*;

public class MyJVMTest_13091 {

    static String msg = "iZO#vU> g>";

    static boolean condition = true;

    static boolean failed = true;

    boolean check(String msg, boolean condition) {
        if (!condition) {
            new Throwable("Test failed " + msg).printStackTrace(System.out);
            failed = true;
        }
        return condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13091().check(msg, condition);
    }
}
