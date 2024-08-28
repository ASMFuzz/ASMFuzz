import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_14677 {

    static String name = "L_XO,+rHu@";

    static MethodType capType = null;

    static Object[] args = { -1499891940, 2, 3, 4, 0, 1976977148, 940543286, 0, 8, 2 };

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    CallSite amfSucceed(MethodHandles.Lookup lookup, String name, MethodType capType, Object[] args) {
        try {
            return LambdaMetafactory.altMetafactory(lookup, name, capType, args);
        } catch (Throwable t) {
            String msg = String.format("Unexpected exception during linkage for altMetafactory(%s, %s, %s, %s)", lookup, name, capType, Arrays.asList(args));
            throw new AssertionError(msg, t);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14677().amfSucceed(lookup, name, capType, args));
    }
}
