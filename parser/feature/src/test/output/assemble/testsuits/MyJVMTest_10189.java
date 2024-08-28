import java.lang.instrument.*;

public class MyJVMTest_10189 {

    static String agentArgs = "$'3<]#WJJ\\";

    static Instrumentation instArg = null;

    Instrumentation premain(String agentArgs, Instrumentation instArg) {
        System.out.println("Hello from Double-Arg InheritAgent1011Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return instArg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10189().premain(agentArgs, instArg);
    }
}
