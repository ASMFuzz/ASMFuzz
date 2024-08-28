import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1671 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "PpInN2%v?i";

    static Object[] staticArgs = {1566323851,3,1099197123,0,2,-409507533,4,1318498936,0,6};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_createTarget() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findVirtual(lookup().lookupClass(), "createTarget", methodType(MethodHandle.class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1671().MH_createTarget());
    }
}
