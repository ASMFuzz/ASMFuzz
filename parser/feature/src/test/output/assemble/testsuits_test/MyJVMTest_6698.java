import java.lang.instrument.*;

public class MyJVMTest_6698 {

    static String agentArgs = "RyR39jV4xx";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1111!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6698().premain(agentArgs);
    }
}
