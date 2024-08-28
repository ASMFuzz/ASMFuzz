import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static java.lang.invoke.MethodHandleInfo.*;

public class MyJVMTest_9304 {

    static MethodHandle mh = null;

    boolean isInvokeSpecial(MethodHandle mh) {
        return specialMethodHandles.contains(mh);
    }

    static Class<?> clazz = null;

    static String name = "XxXbeA< ~'";

    static MethodType methodType = null;

    static Class<?> declaringClass = null;

    static int referenceKind = 0;

    static List<MethodHandle> specialMethodHandles = new ArrayList<>();

    MethodHandle noteInvokeSpecial(MethodHandle mh) {
        specialMethodHandles.add(mh);
        assert (isInvokeSpecial(mh));
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9304().noteInvokeSpecial(mh);
    }
}
