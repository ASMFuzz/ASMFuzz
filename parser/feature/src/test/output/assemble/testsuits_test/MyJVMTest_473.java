import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_473 {

    static boolean condition = true;

    static int failures = 0;

    boolean check(boolean condition) {
        if (!condition) {
            new Error("test failed").printStackTrace();
            failures++;
        }
        return condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_473().check(condition);
    }
}
