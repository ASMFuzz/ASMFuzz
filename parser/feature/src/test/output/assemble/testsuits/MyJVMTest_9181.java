import java.lang.instrument.*;

public class MyJVMTest_9181 {

    static String agentArgs = "i4?~vD`Uhk";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1001Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9181().premain(agentArgs, instArg);
    }
}
