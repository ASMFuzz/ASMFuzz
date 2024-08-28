import java.lang.instrument.*;

public class MyJVMTest_16771 {

    static String agentArgs = "RhOsT>.*,W";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16771().premain(agentArgs);
    }
}
