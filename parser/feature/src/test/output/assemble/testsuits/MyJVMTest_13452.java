import java.lang.instrument.Instrumentation;

public class MyJVMTest_13452 {

    static String options = "xlHI?IM%|L";

    static Instrumentation inst = null;

    static Instrumentation sInstrumentation = null;

    Instrumentation premain(String options, Instrumentation inst) {
        System.out.println("InstrumentationHandoff JPLIS agent initialized");
        sInstrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13452().premain(options, inst);
    }
}
