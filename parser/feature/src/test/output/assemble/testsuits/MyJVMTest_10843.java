import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class MyJVMTest_10843 {

    static String msg = "r9(NxD&aH%";

    static int failed = 0;

    String fail(String msg) {
        err.printf("FAIL: %s%n", msg);
        failed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10843().fail(msg);
    }
}
