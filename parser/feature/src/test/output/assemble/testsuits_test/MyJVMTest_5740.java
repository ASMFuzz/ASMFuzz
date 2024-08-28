import java.lang.instrument.Instrumentation;

public class MyJVMTest_5740 {

    static String agentArgs = "~Rh>B=NU_(";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from " + "RedefineSubclassWithTwoInterfacesAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5740().premain(agentArgs, inst);
    }
}
