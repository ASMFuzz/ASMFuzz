import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_14478 {

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

    static String name = "ESn1TBX*tW";

    static Object[] staticArgs = {0,2,6,0,-1383461687,-2117347230,1,0,7,3};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_bsm() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "bsm", MT_bsm());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14478().MH_bsm());
    }
}
