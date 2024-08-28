import java.lang.invoke.MethodHandle;

public class MyJVMTest_17032 {

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
        new MyJVMTest_17032().testNSME(mh);
    }
}
