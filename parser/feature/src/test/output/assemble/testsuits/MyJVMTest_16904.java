import java.lang.invoke.*;

public class MyJVMTest_16904 {

    static MethodHandle mh = null;

    MethodHandle test(MethodHandle mh) throws Throwable {
        int i1 = (int) mh.invokeExact();
        int i2 = (int) mh.invoke();
        int i3 = (int) mh.invokeWithArguments();
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16904().test(mh);
    }
}
