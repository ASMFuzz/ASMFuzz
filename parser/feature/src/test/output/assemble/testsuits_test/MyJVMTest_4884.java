import java.lang.instrument.*;

public class MyJVMTest_4884 {

    static String agentArgs = "WlH&gVzdGd";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1010Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4884().premain(agentArgs, instArg);
    }
}
