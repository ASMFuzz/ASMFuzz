import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_4242 {

    static int expected = 9;

    static int actual = 1176517968;

    static Class<?> CLASS = CallSiteTest.class;

    static CallSite mcs = null;

    static CallSite vcs = null;

    static MethodHandle mh_foo = null;

    static MethodHandle mh_bar = null;

    int assertEquals(int expected, int actual) {
        if (expected != actual)
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4242().assertEquals(expected, actual);
    }
}
