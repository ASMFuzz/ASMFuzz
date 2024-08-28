import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_10763 {

    static int a = 3;

    static int b = 0;

    static Class<?> CLASS = CallSiteTest.class;

    static CallSite mcs = null;

    static CallSite vcs = null;

    static MethodHandle mh_foo = null;

    static MethodHandle mh_bar = null;

    int bar(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10763().bar(a, b));
    }
}
