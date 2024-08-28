import java.lang.instrument.*;

public class MyJVMTest_8830 {

    static String agentArgs = "!T=%P7h\"S3";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0111!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8830().premain(agentArgs);
    }
}
