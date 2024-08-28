import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12391 {

    static int expected = 874783548;

    static int actual = 0;

    static int Init1Tick = 1928525132;

    static Throwable LAST_LOSER = null;

    int assertEquals(int expected, int actual) {
        if (expected != actual) {
            Throwable loser = new AssertionError("expected: " + expected + ", actual: " + actual);
            if (LAST_LOSER != null)
                LAST_LOSER.printStackTrace(System.out);
            LAST_LOSER = loser;
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12391().assertEquals(expected, actual);
    }
}
