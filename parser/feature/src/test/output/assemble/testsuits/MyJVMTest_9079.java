import java.lang.instrument.*;

public class MyJVMTest_9079 {

    static String agentArgs = "{GuekGz@?R";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9079().premain(agentArgs);
    }
}
