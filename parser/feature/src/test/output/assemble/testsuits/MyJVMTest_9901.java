import java.lang.instrument.*;

public class MyJVMTest_9901 {

    static String agentArgs = "{*DsHUToN<";

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation instrumentation) {
        GetObjectSizeOverflowAgent.instrumentation = instrumentation;
        return instrumentation;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9901().premain(agentArgs, instrumentation);
    }
}
