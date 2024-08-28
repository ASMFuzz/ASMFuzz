import java.lang.instrument.Instrumentation;

public class MyJVMTest_6123 {

    static String agentArgs = "_{1gGj/.mJ";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6123().premain(agentArgs, instArg);
    }
}
