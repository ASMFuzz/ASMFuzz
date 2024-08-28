import java.lang.instrument.*;

public class MyJVMTest_8781 {

    static String agentArgs = "LQ&yPjeRIO";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1011Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8781().premain(agentArgs, instArg);
    }
}
