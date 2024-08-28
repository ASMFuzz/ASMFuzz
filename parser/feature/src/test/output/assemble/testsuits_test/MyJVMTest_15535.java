import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_15535 {

    static int expect = 514669447;

    static int observed = 1;

    static Class<?> clazz = null;

    static String name = "Cp.lB^>whw";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = 5;

    int assertRefKindEquals(int expect, int observed) {
        if (expect == observed)
            return;
        String msg = "expected " + referenceKindToString(expect) + " but observed " + referenceKindToString(observed);
        System.out.println("FAILED: " + msg);
        throw new AssertionError(msg);
        return observed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15535().assertRefKindEquals(expect, observed);
    }
}
