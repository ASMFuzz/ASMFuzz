import java.lang.instrument.*;

public class MyJVMTest_7052 {

    static String agentArgs = "=CjW&\\y?G/";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1110Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7052().premain(agentArgs);
    }
}
