import java.lang.invoke.MethodHandle;

public class MyJVMTest_13240 {

    static MethodHandle MH_m = null;

    void test_call_by_method_handle() throws Throwable {
        MH_m.invokeExact();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13240().test_call_by_method_handle();
    }
}
