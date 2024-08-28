import java.lang.instrument.*;

public class MyJVMTest_1662 {

    static String agentArgs = "cPGG0w)n|l";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1662().premain(agentArgs);
    }
}
