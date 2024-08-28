import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10479 {

    static String name = "q~CJe,]f/d";

    static MethodType capType = null;

    static Object[] args = { -669594512, 1783653748, 7, 0, 2095773624, 0, 0, 5, 0, 9 };

    static Class<?> expectedExceptionType = null;

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    MethodType failAltMFLinkage(MethodHandles.Lookup lookup, String name, MethodType capType, Object[] args, Class<?> expectedExceptionType) {
        try {
            LambdaMetafactory.altMetafactory(lookup, name, capType, args);
        } catch (Throwable t) {
            if (expectedExceptionType.isInstance(t)) {
                return;
            } else {
                String msg = String.format("Unexpected exception: expected %s during linkage for metafactory(%s, %s, %s, %s)", expectedExceptionType.getName(), lookup, name, capType, Arrays.asList(args));
                throw new AssertionError(msg, t);
            }
        }
        String msg = String.format("Unexpected success: expected %s during linkage for metafactory(%s, %s, %s, %s)", expectedExceptionType.getName(), lookup, name, capType, Arrays.asList(args));
        throw new AssertionError(msg);
        return capType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10479().failAltMFLinkage(lookup, name, capType, args, expectedExceptionType);
    }
}
