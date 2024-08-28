import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_7689 {

    static Class<?> exceptionType = null;

    static String name = "<Yzo8T(vUs";

    static MethodType capType = null;

    static MethodType desc = null;

    static MethodHandle impl = null;

    static MethodType checked = null;

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    MethodType mfFail(Class<?> exceptionType, MethodHandles.Lookup lookup, String name, MethodType capType, MethodType desc, MethodHandle impl, MethodType checked) {
        try {
            LambdaMetafactory.metafactory(lookup, name, capType, desc, impl, checked);
        } catch (Throwable t) {
            if (exceptionType.isInstance(t)) {
                return;
            } else {
                String msg = String.format("Unexpected exception: expected %s during linkage for metafactory(%s, %s, %s, %s, %s, %s)", exceptionType.getName(), lookup, name, capType, desc, impl, checked);
                throw new AssertionError(msg, t);
            }
        }
        String msg = String.format("Unexpected success: expected %s during linkage for metafactory(%s, %s, %s, %s, %s, %s)", exceptionType.getName(), lookup, name, capType, desc, impl, checked);
        throw new AssertionError(msg);
        return desc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7689().mfFail(exceptionType, lookup, name, capType, desc, impl, checked);
    }
}
