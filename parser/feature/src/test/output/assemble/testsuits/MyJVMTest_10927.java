import java.lang.instrument.*;

public class MyJVMTest_10927 {

    static String agentArgs = "Z0BNx-Iv^:";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10927().premain(agentArgs, instArg);
    }
}
