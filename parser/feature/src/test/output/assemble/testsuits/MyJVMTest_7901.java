import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_7901 {

    void shouldNotCallThis() {
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    MethodHandle MH_bsm() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "bsm", methodType(CallSite.class, Lookup.class, String.class, MethodType.class));
    }

    static int Init1Tick = 0;

    MethodHandle INDY_baz() throws Throwable {
        shouldNotCallThis();
        return ((CallSite) MH_bsm().invoke(lookup(), "baz", methodType(int.class))).dynamicInvoker();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7901().INDY_baz());
    }
}
