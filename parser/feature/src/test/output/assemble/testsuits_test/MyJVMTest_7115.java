import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_7115 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = ";D]5,K7;F)";

    static Object[] staticArgs = {1358131340,4,-219296242,7,7,5,8,0,2,6};

    MethodHandle MH_createTarget() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findVirtual(lookup().lookupClass(), "createTarget", methodType(MethodHandle.class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7115().MH_createTarget());
    }
}
