import java.lang.invoke.MethodHandle;

public class MyJVMTest_10567 {

    static MethodHandle target = null;

    void run() throws Throwable {
        target.invokeExact((NullConstantReceiver) null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10567().run();
    }
}
