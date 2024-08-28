import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9293 {

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static Lookup caller = null;

    static String name = "6f}ut<$X%O";

    static Object[] staticArgs = {0,1008287992,357055921,6,7,5,7,5,7,0};

    static PermissionCollection permissions = new Permissions();

    MethodType MT_bsm2() {
        shouldNotCallThis();
        return methodType(CallSite.class, Lookup.class, String.class, MethodType.class, Object[].class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9293().MT_bsm2());
    }
}
