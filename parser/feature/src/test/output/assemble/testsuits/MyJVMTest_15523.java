import java.lang.instrument.Instrumentation;

public class MyJVMTest_15523 {

    static String agentArgs = "k1;E7@B/fU";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from RedefineMethodAddInvokeAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15523().premain(agentArgs, inst);
    }
}
