import java.lang.invoke.*;

public class MyJVMTest_10277 {

    static MethodHandle mh1 = null;

    static Class ret = null;

    static Class arg = null;

    MethodHandle getmh2(MethodHandle mh1, Class ret, Class arg) {
        return MethodHandles.explicitCastArguments(mh1, MethodType.methodType(ret, arg));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10277().getmh2(mh1, ret, arg));
    }
}
