import java.lang.instrument.Instrumentation;

public class MyJVMTest_4093 {

    static String options = "'pQ8T ,Q_a";

    static Instrumentation inst = null;

    static Instrumentation sInstrumentation = null;

    Instrumentation premain(String options, Instrumentation inst) {
        System.out.println("InstrumentationHandoff JPLIS agent initialized");
        sInstrumentation = inst;
        return inst;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4093().premain(options, inst);
    }
}
