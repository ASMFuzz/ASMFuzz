import java.lang.instrument.*;

public class MyJVMTest_9136 {

    static String agentArgs = "aQ~hiG[O\\d";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1101Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9136().premain(agentArgs, instArg);
    }
}
