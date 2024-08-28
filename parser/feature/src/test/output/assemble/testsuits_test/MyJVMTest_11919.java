import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11919 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    MethodType MT_bsm2() {
        shouldNotCallThis();
        return methodType(CallSite.class, Lookup.class, String.class, MethodType.class, Object[].class);
    }

    static Lookup caller = null;

    static String name = "ll_FHp6RHI";

    static Object[] staticArgs = {3,1358248670,-601637609,0,0,4,5,-331051364,0,-796723678};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_bsm2() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "bsm2", MT_bsm2());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11919().MH_bsm2());
    }
}
