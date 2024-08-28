import java.lang.instrument.Instrumentation;

public class MyJVMTest_17994 {

    static String agentArgs = "EDyTQ-M}]*";

    static Instrumentation inst = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from ManifestTestAgent!");
        System.out.println("isNativeMethodPrefixSupported()=" + inst.isNativeMethodPrefixSupported());
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        System.out.println("isRetransformClassesSupported()=" + inst.isRetransformClassesSupported());
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17994().premain(agentArgs, inst);
    }
}
