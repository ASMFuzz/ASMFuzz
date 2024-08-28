import java.lang.instrument.*;

public class MyJVMTest_1705 {

    static String agentArgs = "40wJx};d'i";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1705().premain(agentArgs, instArg);
    }
}
