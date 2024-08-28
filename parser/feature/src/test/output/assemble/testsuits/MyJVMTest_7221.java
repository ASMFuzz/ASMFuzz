import java.lang.instrument.Instrumentation;

public class MyJVMTest_7221 {

    static String agentArgs = "Z(oY<8gFfV";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1000Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7221().premain(agentArgs, instArg);
    }
}
