import java.lang.invoke.*;

public class MyJVMTest_3859 {

    static MethodHandle mh = null;

    MethodHandle test2(MethodHandle mh) throws Throwable {
        int i1 = (int) (mh.invokeExact());
        int i2 = (int) (mh.invoke());
        int i3 = (int) (mh.invokeWithArguments());
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3859().test2(mh);
    }
}
