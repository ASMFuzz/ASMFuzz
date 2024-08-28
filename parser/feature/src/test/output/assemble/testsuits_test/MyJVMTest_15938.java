import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_15938 {

    static String name = "%IX0TI(@W<";

    static MethodType capType = null;

    static MethodType desc = null;

    static MethodHandle impl = null;

    static MethodType checked = null;

    static Class<?> expectedExceptionType = null;

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    MethodType failMFLinkage(MethodHandles.Lookup lookup, String name, MethodType capType, MethodType desc, MethodHandle impl, MethodType checked, Class<?> expectedExceptionType) {
        try {
            LambdaMetafactory.metafactory(lookup, name, capType, desc, impl, checked);
        } catch (Throwable t) {
            if (expectedExceptionType.isInstance(t)) {
                return;
            } else {
                String msg = String.format("Unexpected exception: expected %s during linkage for metafactory(%s, %s, %s, %s, %s, %s)", expectedExceptionType.getName(), lookup, name, capType, desc, impl, checked);
                throw new AssertionError(msg, t);
            }
        }
        String msg = String.format("Unexpected success: expected %s during linkage for metafactory(%s, %s, %s, %s, %s, %s)", expectedExceptionType.getName(), lookup, name, capType, desc, impl, checked);
        throw new AssertionError(msg);
        return desc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15938().failMFLinkage(lookup, name, capType, desc, impl, checked, expectedExceptionType);
    }
}
