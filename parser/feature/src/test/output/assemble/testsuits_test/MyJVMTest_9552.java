import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9552 {

    static Object exp = 3;

    static Object act = 3;

    static Lookup caller = null;

    static String name = "',c)hCVjL5";

    static Object[] staticArgs = {0,5,589445621,0,5,3,-1512833581,4,7,212888050};

    static PermissionCollection permissions = new Permissions();

    Object assertEquals(Object exp, Object act) {
        if (exp == act || (exp != null && exp.equals(act)))
            return;
        throw new AssertionError("not equal: " + exp + ", " + act);
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9552().assertEquals(exp, act);
    }
}
