import java.lang.instrument.*;

public class MyJVMTest_16194 {

    static String agentArgs = "LdQY:b{gMe";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1111!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16194().premain(agentArgs);
    }
}
