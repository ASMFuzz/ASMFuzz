import java.lang.invoke.*;

public class MyJVMTest_2748 {

    static boolean x = false;

    static Class CLASS = Test6987555.class;

    static String NAME = "foo";

    static boolean DEBUG = false;

    boolean doboolean(boolean x) throws Throwable {
        if (DEBUG)
            System.out.println("boolean=" + x);
        MethodHandle mh1 = MethodHandles.lookup().findStatic(CLASS, NAME, MethodType.methodType(boolean.class, boolean.class));
        MethodHandle mh2 = mh1.asType(MethodType.methodType(boolean.class, Boolean.class));
        boolean a = (boolean) mh1.invokeExact(x);
        boolean b = (boolean) mh2.invokeExact(Boolean.valueOf(x));
        assert a == b : a + " != " + b;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2748().doboolean(x);
    }
}
