import java.lang.invoke.*;

public class MyJVMTest_6287 {

    static short x = 0;

    static Class CLASS = Test6987555.class;

    static String NAME = "foo";

    static boolean DEBUG = false;

    short doshort(short x) throws Throwable {
        if (DEBUG)
            System.out.println("short=" + x);
        MethodHandle mh1 = MethodHandles.lookup().findStatic(CLASS, NAME, MethodType.methodType(short.class, short.class));
        MethodHandle mh2 = mh1.asType(MethodType.methodType(short.class, Short.class));
        short a = (short) mh1.invokeExact(x);
        short b = (short) mh2.invokeExact(Short.valueOf(x));
        assert a == b : a + " != " + b;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6287().doshort(x);
    }
}
