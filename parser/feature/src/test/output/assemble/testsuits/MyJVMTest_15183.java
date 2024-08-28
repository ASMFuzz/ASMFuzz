import java.lang.instrument.Instrumentation;

public class MyJVMTest_15183 {

    static String agentArgs = "li3T$mm2Uo";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from " + "RedefineSubclassWithTwoInterfacesAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15183().premain(agentArgs, inst);
    }
}
