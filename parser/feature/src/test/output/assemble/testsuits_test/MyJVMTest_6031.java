import java.lang.instrument.*;

public class MyJVMTest_6031 {

    static String agentArgs = "39H6 3>;06";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6031().premain(agentArgs);
    }
}
