import java.lang.instrument.*;

public class MyJVMTest_11878 {

    static String agentArgs = "6y'eF8Hcea";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0111!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11878().premain(agentArgs);
    }
}
