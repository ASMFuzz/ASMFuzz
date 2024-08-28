import java.lang.instrument.*;

public class MyJVMTest_9092 {

    static String agentArgs = "5lSbxgB%+h";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1011!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9092().premain(agentArgs);
    }
}
