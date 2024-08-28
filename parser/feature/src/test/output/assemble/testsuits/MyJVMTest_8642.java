import java.lang.instrument.*;

public class MyJVMTest_8642 {

    static String agentArgs = "LL`iu}-E\\J";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8642().premain(agentArgs);
    }
}
