import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

public class MyJVMTest_1480 {

    static MethodHandle mh = null;

    static MethodHandles.Lookup L = MethodHandles.lookup();

    MethodHandle test(MethodHandle mh) {
        try {
            mh.invokeExact();
            throw new AssertionError("No exception thrown");
        } catch (LinkageError e) {
            return;
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable e) {
            throw new AssertionError("Unexpected exception", e);
        }
        return mh;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1480().test(mh);
    }
}
