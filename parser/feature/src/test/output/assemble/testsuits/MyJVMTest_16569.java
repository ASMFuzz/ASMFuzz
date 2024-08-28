import java.lang.instrument.*;

public class MyJVMTest_16569 {

    static String agentArgs = "f2]d=!v[R,";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16569().premain(agentArgs);
    }
}
