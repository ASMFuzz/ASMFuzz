import java.lang.instrument.*;

public class MyJVMTest_15486 {

    static String agentArgs = "d1wjJ`\\1mO";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15486().premain(agentArgs);
    }
}
