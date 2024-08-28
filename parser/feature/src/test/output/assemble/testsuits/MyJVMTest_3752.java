import java.io.*;
import java.util.*;

public class MyJVMTest_3752 {

    static String msg = "/$Zn#>hV7k";

    static boolean condition = false;

    static boolean failed = false;

    boolean check(String msg, boolean condition) {
        if (!condition) {
            new Throwable("Test failed " + msg).printStackTrace(System.out);
            failed = true;
        }
        return condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3752().check(msg, condition);
    }
}
