import java.lang.instrument.*;

public class MyJVMTest_723 {

    static String agentArgs = "5-Sn:$|L>>";

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation instrumentation) {
        GetObjectSizeOverflowAgent.instrumentation = instrumentation;
        return instrumentation;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_723().premain(agentArgs, instrumentation);
    }
}
