import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10376 {

    static Class<?> exceptionType = null;

    static String name = "R*/v8g,p5a";

    static MethodType capType = null;

    static Object[] args = { 8, -1375977950, -1214673815, 1, 1212642850, 2131256843, 0, 0, -127646032, 625955533 };

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    MethodType amfFail(Class<?> exceptionType, MethodHandles.Lookup lookup, String name, MethodType capType, Object[] args) {
        try {
            LambdaMetafactory.altMetafactory(lookup, name, capType, args);
        } catch (Throwable t) {
            if (exceptionType.isInstance(t)) {
                return;
            } else {
                String msg = String.format("Unexpected exception: expected %s during linkage for altMetafactory(%s, %s, %s, %s)", exceptionType.getName(), lookup, name, capType, Arrays.asList(args));
                throw new AssertionError(msg, t);
            }
        }
        String msg = String.format("Unexpected success: expected %s during linkage for altMetafactory(%s, %s, %s, %s)", exceptionType.getName(), lookup, name, capType, Arrays.asList(args));
        throw new AssertionError(msg);
        return capType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10376().amfFail(exceptionType, lookup, name, capType, args);
    }
}
