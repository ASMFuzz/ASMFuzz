import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_2447 {

    static Lookup caller = null;

    static String name = "+Qz>[r_;Og";

    static Object[] staticArgs = {0,6,3,9,0,5,-755519658,9,3,0};

    static PermissionCollection permissions = new Permissions();

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2447().shouldNotCallThis();
    }
}
