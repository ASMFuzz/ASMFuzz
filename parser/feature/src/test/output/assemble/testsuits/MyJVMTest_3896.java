import java.lang.invoke.MethodHandle;

public class MyJVMTest_3896 {

    static MethodHandle MH_m = null;

    void test_call_by_method_handle() throws Throwable {
        MH_m.invokeExact();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3896().test_call_by_method_handle();
    }
}
