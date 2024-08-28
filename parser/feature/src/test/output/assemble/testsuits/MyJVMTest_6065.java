import java.lang.instrument.Instrumentation;

public class MyJVMTest_6065 {

    static String agentArgs = "zU:9L>T\"3]";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from RedefineMethodAddInvokeAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6065().premain(agentArgs, inst);
    }
}
