import java.lang.instrument.*;

public class MyJVMTest_16832 {

    static String agentArgs = ":Df@|SPQO=";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1011!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16832().premain(agentArgs);
    }
}
