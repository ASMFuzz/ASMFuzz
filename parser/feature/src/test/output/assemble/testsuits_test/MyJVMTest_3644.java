import java.lang.invoke.*;

public class MyJVMTest_3644 {

    static char x = Character.MIN_VALUE;

    static Class CLASS = Test6987555.class;

    static String NAME = "foo";

    static boolean DEBUG = false;

    char dochar(char x) throws Throwable {
        if (DEBUG)
            System.out.println("char=" + x);
        MethodHandle mh1 = MethodHandles.lookup().findStatic(CLASS, NAME, MethodType.methodType(char.class, char.class));
        MethodHandle mh2 = mh1.asType(MethodType.methodType(char.class, Character.class));
        char a = (char) mh1.invokeExact(x);
        char b = (char) mh2.invokeExact(Character.valueOf(x));
        assert a == b : a + " != " + b;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3644().dochar(x);
    }
}
