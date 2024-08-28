import java.lang.invoke.MethodHandle;

public class MyJVMTest_7495 {

    static MethodHandle mh = null;

    MethodHandle testNSME(MethodHandle mh) {
        try {
            mh.invokeExact();
            throw new AssertionError("No exception thrown");
        } catch (NoSuchMethodError e) {
            return;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            throw new AssertionError("Unexpected exception", e);
        }
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7495().testNSME(mh);
    }
}
