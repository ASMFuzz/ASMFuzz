import java.lang.invoke.MethodHandle;

public class MyJVMTest_16207 {

    void m() {
    }

    static MethodHandle MH_m = null;

    void test_direct_call() {
        MyInterface.m();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16207().test_direct_call();
    }
}
