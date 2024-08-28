import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_10811 {

    static Object exp = 2;

    static Object act = -1619655399;

    static PermissionCollection permissions = new Permissions();

    Object assertEquals(Object exp, Object act) {
        if (exp == act || (exp != null && exp.equals(act)))
            return;
        throw new AssertionError("not equal: " + exp + ", " + act);
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10811().assertEquals(exp, act);
    }
}
