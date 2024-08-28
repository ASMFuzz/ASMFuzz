import java.lang.instrument.*;

public class MyJVMTest_8708 {

    static String agentArgs = "?ArlIVpR>U";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0011!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8708().premain(agentArgs);
    }
}
