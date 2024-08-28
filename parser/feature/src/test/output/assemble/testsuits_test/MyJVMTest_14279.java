import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_14279 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "X'd\\[7|Q $";

    static Object[] staticArgs = {5,0,3,0,0,7,0,0,1,9};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_printArgs() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "printArgs", methodType(void.class, Object.class, Object[].class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14279().MH_printArgs());
    }
}
