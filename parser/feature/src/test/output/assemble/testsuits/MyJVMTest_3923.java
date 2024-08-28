import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MyJVMTest_3923 {

    static String classname = "Kn9Y0n4<DE";

    static String methodname = "!AJC V~.U5";

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
        new MyJVMTest_3923().testMethodHandle();
    }
}
