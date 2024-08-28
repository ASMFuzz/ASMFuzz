import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1590 {

    static Object exp = 1821410891;

    static Object act = -1440493707;

    static PermissionCollection permissions = new Permissions();

    Object assertEquals(Object exp, Object act) {
        if (exp == act || (exp != null && exp.equals(act)))
            return;
        throw new AssertionError("not equal: " + exp + ", " + act);
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1590().assertEquals(exp, act);
    }
}
