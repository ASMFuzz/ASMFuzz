import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_11697 {

    static Object expect = 3;

    static Object observed = 0;

    static Class<?> clazz = null;

    static String name = "hIpEW] I/n";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = 0;

    Object assertEquals(Object expect, Object observed) {
        if (java.util.Objects.equals(expect, observed))
            return;
        String msg = "expected " + expect + " but observed " + observed;
        System.out.println("FAILED: " + msg);
        throw new AssertionError(msg);
        return observed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11697().assertEquals(expect, observed);
    }
}
