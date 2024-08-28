import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_845 {

    static String name = "UPJ43A{:6S";

    static MethodType capType = null;

    static MethodType desc = null;

    static MethodHandle impl = null;

    static MethodType checked = null;

    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    CallSite mfSucceed(MethodHandles.Lookup lookup, String name, MethodType capType, MethodType desc, MethodHandle impl, MethodType checked) {
        try {
            return LambdaMetafactory.metafactory(lookup, name, capType, desc, impl, checked);
        } catch (Throwable t) {
            String msg = String.format("Unexpected exception during linkage for metafactory(%s, %s, %s, %s, %s, %s)", lookup, name, capType, desc, impl, checked);
            throw new AssertionError(msg, t);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_845().mfSucceed(lookup, name, capType, desc, impl, checked));
    }
}
