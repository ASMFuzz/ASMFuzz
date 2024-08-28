import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_9633 {

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
        new MyJVMTest_9633().check(condition);
    }
}
