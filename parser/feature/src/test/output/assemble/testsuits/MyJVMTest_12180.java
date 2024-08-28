import java.lang.invoke.MethodHandle;

public class MyJVMTest_12180 {

    static MethodHandle mh = null;

    MethodHandle testICCE(MethodHandle mh) {
        try {
            mh.invokeExact();
            throw new AssertionError("No exception thrown");
        } catch (IncompatibleClassChangeError e) {
            return;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            throw new AssertionError("Unexpected exception", e);
        }
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12180().testICCE(mh);
    }
}
