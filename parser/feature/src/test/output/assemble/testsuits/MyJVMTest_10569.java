import java.lang.instrument.Instrumentation;

public class MyJVMTest_10569 {

    static String agentArgs = "!/C@uX<z8r";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from RedefineMethodDelInvokeAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10569().premain(agentArgs, inst);
    }
}
