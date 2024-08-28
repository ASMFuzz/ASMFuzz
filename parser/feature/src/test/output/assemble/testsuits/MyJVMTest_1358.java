import java.lang.invoke.MethodHandle;

public class MyJVMTest_1358 {

    static MethodHandle target = null;

    void run() throws Throwable {
        target.invokeExact((NullConstantReceiver) null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1358().run();
    }
}
