import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_3631 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "7S|=c?lX:p";

    static Object[] staticArgs = {556648116,-1651873106,0,9,8,4,559978347,9,6,0};

    static PermissionCollection permissions = new Permissions();

    MethodType MT_bsm() {
        shouldNotCallThis();
        return methodType(CallSite.class, Lookup.class, String.class, MethodType.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3631().MT_bsm());
    }
}
