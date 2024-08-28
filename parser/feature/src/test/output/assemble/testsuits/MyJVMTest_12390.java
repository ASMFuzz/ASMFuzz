import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12390 {

    void shouldNotCallThis() {
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Class<?> CLASS = CallSiteTest.class;

    static CallSite mcs = null;

    static CallSite vcs = null;

    static MethodHandle mh_foo = null;

    static MethodHandle mh_bar = null;

    static int N = Integer.MAX_VALUE / 100;

    MethodType MT_bsm() {
        shouldNotCallThis();
        return methodType(CallSite.class, Lookup.class, String.class, MethodType.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12390().MT_bsm());
    }
}
