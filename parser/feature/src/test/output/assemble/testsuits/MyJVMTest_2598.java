import java.lang.instrument.*;

public class MyJVMTest_2598 {

    static String agentArgs = "G$#YhD0/|g";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0111!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2598().premain(agentArgs);
    }
}
