import java.lang.instrument.Instrumentation;

public class MyJVMTest_7696 {

    static String agentArgs = "_<[pSyE%ZO";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from RedefineMethodInBacktraceAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7696().premain(agentArgs, inst);
    }
}
