import java.lang.instrument.Instrumentation;

public class MyJVMTest_4165 {

    Instrumentation getInstrumentation() {
        return sInstrumentation;
    }

    static Instrumentation sInstrumentation = null;

    Instrumentation getInstrumentationOrThrow() {
        Instrumentation result = getInstrumentation();
        if (result == null) {
            throw new NullPointerException("instrumentation instance not initialized");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4165().getInstrumentationOrThrow());
    }
}
