import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_13608 {

    static int expected = 6;

    static int actual = 0;

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
        new MyJVMTest_13608().assertEquals(expected, actual);
    }
}
