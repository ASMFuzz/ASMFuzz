import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_395 {

    static Object exp = -1479550007;

    static Object act = 3;

    static Lookup caller = null;

    static String name = "1XuXlKmc]z";

    static Object[] staticArgs = {8,9,1,7,0,7,6,1,3,-2101709674};

    static PermissionCollection permissions = new Permissions();

    Object assertEquals(Object exp, Object act) {
        if (exp == act || (exp != null && exp.equals(act)))
            return;
        throw new AssertionError("not equal: " + exp + ", " + act);
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_395().assertEquals(exp, act);
    }
}
