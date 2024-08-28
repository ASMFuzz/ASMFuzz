import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_6077 {

    static int expect = 5;

    static int observed = 10973951;

    static Class<?> clazz = null;

    static String name = "rN'\\?`!eDN";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = 1;

    int assertRefKindEquals(int expect, int observed) {
        if (expect == observed)
            return;
        String msg = "expected " + referenceKindToString(expect) + " but observed " + referenceKindToString(observed);
        System.out.println("FAILED: " + msg);
        throw new AssertionError(msg);
        return observed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6077().assertRefKindEquals(expect, observed);
    }
}
