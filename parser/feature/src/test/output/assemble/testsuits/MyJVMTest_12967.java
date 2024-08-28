import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_12967 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "K{ld0cnC^4";

    static Object[] staticArgs = {0,0,9,6,0,1,5,0,1450262747,7};

    static PermissionCollection permissions = new Permissions();

    MethodType MT_bsm() {
        shouldNotCallThis();
        return methodType(CallSite.class, Lookup.class, String.class, MethodType.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12967().MT_bsm());
    }
}
