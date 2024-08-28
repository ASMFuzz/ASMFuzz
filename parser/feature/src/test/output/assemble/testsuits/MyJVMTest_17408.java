import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_17408 {

    static int a = 1895962911;

    static int b = 1851125610;

    static Class<?> CLASS = CallSiteTest.class;

    static CallSite mcs = null;

    static CallSite vcs = null;

    static MethodHandle mh_foo = null;

    static MethodHandle mh_bar = null;

    int foo(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17408().foo(a, b));
    }
}
