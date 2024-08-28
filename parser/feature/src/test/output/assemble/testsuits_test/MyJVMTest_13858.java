import java.lang.instrument.*;

public class MyJVMTest_13858 {

    static String agentArgs = "WeI_*P#p$y";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0101Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13858().premain(agentArgs);
    }
}
