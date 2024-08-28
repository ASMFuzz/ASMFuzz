import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class MyJVMTest_1621 {

    static String msg = "d-0+/whGkG";

    static int failed = 0;

    String fail(String msg) {
        err.printf("FAIL: %s%n", msg);
        failed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1621().fail(msg);
    }
}
