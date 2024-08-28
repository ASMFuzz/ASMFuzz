import java.lang.instrument.*;

public class MyJVMTest_8687 {

    static String agentArgs = "5CTB=2 -FV";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8687().premain(agentArgs, instArg);
    }
}
