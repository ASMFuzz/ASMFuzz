import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_5065 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    MethodType MT_bsm() {
        shouldNotCallThis();
        return methodType(CallSite.class, Lookup.class, String.class, MethodType.class);
    }

    static Lookup caller = null;

    static String name = " txO[3L.#>";

    static Object[] staticArgs = {9,2,255631639,0,0,3,0,7,8,6};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_bsm() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "bsm", MT_bsm());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5065().MH_bsm());
    }
}
