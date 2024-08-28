import java.io.*;
import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_5926 {

    void shouldNotCallThis() {
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    MethodHandle MH_bsm() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "bsm", methodType(CallSite.class, Lookup.class, String.class, MethodType.class));
    }

    static int Init1Tick = 7;

    MethodHandle INDY_bat() throws Throwable {
        shouldNotCallThis();
        return ((CallSite) MH_bsm().invoke(lookup(), "bat", methodType(int.class))).dynamicInvoker();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5926().INDY_bat());
    }
}
