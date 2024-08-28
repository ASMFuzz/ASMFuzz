import java.lang.instrument.*;

public class MyJVMTest_5052 {

    static String agentArgs = "v8#{O)e:\"u";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5052().premain(agentArgs, instArg);
    }
}
