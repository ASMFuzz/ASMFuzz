import java.lang.instrument.*;

public class MyJVMTest_7248 {

    static String agentArgs = "/Sv9I~bL!O";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7248().premain(agentArgs);
    }
}
