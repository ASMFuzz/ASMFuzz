import java.lang.invoke.MethodHandle;
import java.lang.invoke.WrongMethodTypeException;

public class MyJVMTest_14361 {

    static MethodHandle mh = null;

    static Object instance = -1082173489;

    MethodHandle invokeVirtual(MethodHandle mh, Object instance) throws WrongMethodTypeException, ClassCastException, Throwable {
        mh.invoke(instance);
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14361().invokeVirtual(mh, instance);
    }
}
