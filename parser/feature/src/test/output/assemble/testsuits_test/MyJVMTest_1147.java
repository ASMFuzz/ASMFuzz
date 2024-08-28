import java.lang.instrument.Instrumentation;

public class MyJVMTest_1147 {

    static String agentArgs = "KFJ*^Kq{m#";

    static Instrumentation inst = null;

    static Instrumentation instrumentation = null;

    Instrumentation premain(String agentArgs, Instrumentation inst) {
        System.out.println("Hello from RedefineMethodWithAnnotationsAgent!");
        System.out.println("isRedefineClassesSupported()=" + inst.isRedefineClassesSupported());
        instrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1147().premain(agentArgs, inst);
    }
}
