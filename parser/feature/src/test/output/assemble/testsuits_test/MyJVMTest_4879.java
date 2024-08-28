import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_4879 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "3l|G\\}0vBU";

    static Object[] staticArgs = {1,0,0,0,0,778311779,-56973337,0,2,5};

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_printArgs() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(lookup().lookupClass(), "printArgs", methodType(void.class, Object.class, Object[].class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4879().MH_printArgs());
    }
}
