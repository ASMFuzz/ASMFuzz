import java.lang.instrument.*;

public class MyJVMTest_8905 {

    static String agentArgs = "TU@9>5}w7p";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8905().premain(agentArgs);
    }
}
