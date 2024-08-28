import java.lang.instrument.*;

public class MyJVMTest_9111 {

    static String agentArgs = "4XIb9n+^9]";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1001Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9111().premain(agentArgs, instArg);
    }
}
