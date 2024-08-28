import java.lang.instrument.*;

public class MyJVMTest_1047 {

    static String agentArgs = "oXA}4l!GJO";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0011!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1047().premain(agentArgs);
    }
}
