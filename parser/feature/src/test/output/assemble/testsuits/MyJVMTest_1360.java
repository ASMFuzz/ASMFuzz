import java.lang.instrument.Instrumentation;

public class MyJVMTest_1360 {

    static String agentArgs = "F0Xs/5G!U?";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from RedefineMethodDelInvokeAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1360().premain(agentArgs, inst);
    }
}
