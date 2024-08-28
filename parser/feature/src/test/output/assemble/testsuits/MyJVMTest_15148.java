import java.lang.invoke.*;

public class MyJVMTest_15148 {

    static Class ret = null;

    static Class arg = null;

    static Class CLASS = Test6991596.class;

    static String NAME = "foo";

    MethodHandle getmh1(Class ret, Class arg) throws ReflectiveOperationException {
        return MethodHandles.lookup().findStatic(CLASS, NAME, MethodType.methodType(ret, arg));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15148().getmh1(ret, arg));
    }
}
