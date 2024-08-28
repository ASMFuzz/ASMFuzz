import java.lang.instrument.*;

public class MyJVMTest_8847 {

    static String agentArgs = "tPD;YA=_vM";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1101Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8847().premain(agentArgs);
    }
}
