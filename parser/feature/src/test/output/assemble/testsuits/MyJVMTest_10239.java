import java.lang.instrument.*;

public class MyJVMTest_10239 {

    static String agentArgs = "am)RJqsrKh";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0011!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10239().premain(agentArgs);
    }
}
