import java.lang.instrument.*;

public class MyJVMTest_18023 {

    static String agentArgs = ",uk2ps@F8!";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1101Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18023().premain(agentArgs);
    }
}
