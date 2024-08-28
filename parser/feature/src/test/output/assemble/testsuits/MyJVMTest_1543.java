import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1543 {

    static int a = 1405917315;

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
        System.out.println(new MyJVMTest_1543().bar(a, b));
    }
}
