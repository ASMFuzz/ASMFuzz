import java.lang.instrument.*;

public class MyJVMTest_8974 {

    static String agentArgs = "cvP#[E[YwD";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0101Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8974().premain(agentArgs);
    }
}
