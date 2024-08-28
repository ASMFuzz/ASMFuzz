import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2637 {

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

    static String name = "S5@3;?t7([";

    static Object[] staticArgs = {0,0,-494187483,5,-351018468,0,0,-2085851506,4,-723474283};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_bsm2() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "bsm2", MT_bsm2());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2637().MH_bsm2());
    }
}
