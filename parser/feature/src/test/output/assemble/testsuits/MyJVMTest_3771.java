import java.lang.invoke.*;

public class MyJVMTest_3771 {

    static byte x = 12;

    static Class CLASS = Test6987555.class;

    static String NAME = "foo";

    static boolean DEBUG = false;

    byte dobyte(byte x) throws Throwable {
        if (DEBUG)
            System.out.println("byte=" + x);
        MethodHandle mh1 = MethodHandles.lookup().findStatic(CLASS, NAME, MethodType.methodType(byte.class, byte.class));
        MethodHandle mh2 = mh1.asType(MethodType.methodType(byte.class, Byte.class));
        byte a = (byte) mh1.invokeExact(x);
        byte b = (byte) mh2.invokeExact(Byte.valueOf(x));
        assert a == b : a + " != " + b;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3771().dobyte(x);
    }
}
