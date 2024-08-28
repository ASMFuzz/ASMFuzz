import java.lang.instrument.Instrumentation;

public class MyJVMTest_13897 {

    static String agentArgs = "qZ!7#dNE[h";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    static String agentArguments = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
        agentArguments = agentArgs;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13897().premain(agentArgs, inst);
    }
}
