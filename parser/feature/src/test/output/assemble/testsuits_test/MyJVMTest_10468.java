import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10468 {

    static String name = "8jfZVaZg~%";

    static MethodType capType = null;

    static Object[] args = { 1, 3, 3, 0, 8, 0, 2, 0, -1054294317, 0 };

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    CallSite succeedAltMFLinkage(MethodHandles.Lookup lookup, String name, MethodType capType, Object[] args) {
        try {
            return LambdaMetafactory.altMetafactory(lookup, name, capType, args);
        } catch (Throwable t) {
            String msg = String.format("Unexpected exception during linkage for metafactory(%s, %s, %s, %s)", lookup, name, capType, Arrays.asList(args));
            throw new AssertionError(msg, t);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10468().succeedAltMFLinkage(lookup, name, capType, args));
    }
}
