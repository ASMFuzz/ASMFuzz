import java.lang.instrument.Instrumentation;

public class MyJVMTest_15588 {

    static String agentArgs = "=-.K50](RJ";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15588().premain(agentArgs, instArg);
    }
}
