import java.lang.instrument.*;

public class MyJVMTest_12163 {

    static boolean fail = false;

    static boolean completed = false;

    static Instrumentation instrumentation = null;

    void instr() {
        System.out.println("ManyMethodsBenchmarkAgent.instr started");
        Class[] allClasses = instrumentation.getAllLoadedClasses();
        for (int i = 0; i < allClasses.length; i++) {
            Class klass = allClasses[i];
            String name = klass.getName();
            if (!name.equals("Base")) {
                continue;
            }
            System.err.println("Instrumenting the class: " + klass);
            try {
                instrumentation.retransformClasses(klass);
            } catch (Throwable e) {
                System.err.println("Error: bad return from retransform: " + klass);
                System.err.println("  ERROR: " + e);
                fail = true;
            }
        }
        completed = true;
        System.out.println("ManyMethodsBenchmarkAgent.instr finished");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12163().instr();
    }
}
