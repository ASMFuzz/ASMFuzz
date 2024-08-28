import java.lang.instrument.Instrumentation;

public class MyJVMTest_4509 {

    static String agentArgs = ";.1j\\FsKRR";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    static String agentArguments = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
        agentArguments = agentArgs;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4509().premain(agentArgs, inst);
    }
}
