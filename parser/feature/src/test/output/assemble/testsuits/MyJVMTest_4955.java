import java.lang.invoke.MethodHandle;
import java.lang.invoke.WrongMethodTypeException;

public class MyJVMTest_4955 {

    static MethodHandle mh = null;

    static Object instance = 7;

    MethodHandle invokeVirtual(MethodHandle mh, Object instance) throws WrongMethodTypeException, ClassCastException, Throwable {
        mh.invoke(instance);
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4955().invokeVirtual(mh, instance);
    }
}
