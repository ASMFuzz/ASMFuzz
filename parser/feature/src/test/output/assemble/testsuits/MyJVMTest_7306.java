import java.lang.instrument.*;

public class MyJVMTest_7306 {

    static String agentArgs = "G7Mbx[?f[p";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1011!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7306().premain(agentArgs);
    }
}
