import java.lang.invoke.*;

public class MyJVMTest_12657 {

    static int x = 0;

    static Class CLASS = Test6987555.class;

    static String NAME = "foo";

    static boolean DEBUG = false;

    int doint(int x) throws Throwable {
        if (DEBUG)
            System.out.println("int=" + x);
        MethodHandle mh1 = MethodHandles.lookup().findStatic(CLASS, NAME, MethodType.methodType(int.class, int.class));
        MethodHandle mh2 = mh1.asType(MethodType.methodType(int.class, Integer.class));
        int a = (int) mh1.invokeExact(x);
        int b = (int) mh2.invokeExact(Integer.valueOf(x));
        assert a == b : a + " != " + b;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12657().doint(x);
    }
}
