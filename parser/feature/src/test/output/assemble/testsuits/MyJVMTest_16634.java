import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_16634 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "9v$IJ];f]1";

    static Object[] staticArgs = {3,0,0,5,1608278358,0,-1884451070,1,5,0};

    MethodHandle MH_createTarget() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findVirtual(lookup().lookupClass(), "createTarget", methodType(MethodHandle.class));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16634().MH_createTarget());
    }
}
