import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_10893 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "GRSpq4N)N+";

    static Object[] staticArgs = {0,0,0,0,84470117,0,8,1166456890,0,1307008563};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_createTarget() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findVirtual(lookup().lookupClass(), "createTarget", methodType(MethodHandle.class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10893().MH_createTarget());
    }
}
