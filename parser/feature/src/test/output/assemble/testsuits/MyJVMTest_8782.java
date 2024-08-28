import java.lang.instrument.*;

public class MyJVMTest_8782 {

    static String agentArgs = "Lek*iK2{o*";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8782().premain(agentArgs, instArg);
    }
}
