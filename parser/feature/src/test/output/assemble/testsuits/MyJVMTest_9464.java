import java.lang.instrument.*;

public class MyJVMTest_9464 {

    static String agentArgs = ";ai_c|+4:)";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9464().premain(agentArgs);
    }
}
