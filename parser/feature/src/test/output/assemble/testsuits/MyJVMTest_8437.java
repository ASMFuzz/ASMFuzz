import java.lang.instrument.*;

public class MyJVMTest_8437 {

    static String agentArgs = "j>wwjpzw%@";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1101Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8437().premain(agentArgs);
    }
}
