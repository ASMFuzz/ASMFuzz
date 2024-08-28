import java.lang.instrument.*;

public class MyJVMTest_17434 {

    static String agentArgs = "9Ip!B+#OfM";

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation instrumentation) {
        GetObjectSizeClassAgent.instrumentation = instrumentation;
        return instrumentation;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17434().premain(agentArgs, instrumentation);
    }
}
