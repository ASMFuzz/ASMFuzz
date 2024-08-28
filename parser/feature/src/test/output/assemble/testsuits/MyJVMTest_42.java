import java.lang.instrument.*;

public class MyJVMTest_42 {

    static String agentArgs = "bZ$c;PfX)&";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1001Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_42().premain(agentArgs, instArg);
    }
}
