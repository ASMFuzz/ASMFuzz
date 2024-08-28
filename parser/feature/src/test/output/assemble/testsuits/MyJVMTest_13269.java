import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MyJVMTest_13269 {

    static String classname = "4(W\"70~Wc>";

    static String methodname = "*N,d1<32[O";

    void testMethodHandle() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            MethodHandle handle = lookup.findStatic(DumpStackTest.class, "methodHandle", MethodType.methodType(void.class));
            handle.invoke();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13269().testMethodHandle();
    }
}
