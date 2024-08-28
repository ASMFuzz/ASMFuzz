import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_11714 {

    static Lookup caller = null;

    static String name = "4 h\\N|2d(C";

    static Object[] staticArgs = {2,0,-1748504277,0,0,-1161428544,-1878900487,0,7,0};

    static PermissionCollection permissions = new Permissions();

    void shouldNotCallThis() {
        if (System.getProperty("InvokeDynamicPrintArgs.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11714().shouldNotCallThis();
    }
}
