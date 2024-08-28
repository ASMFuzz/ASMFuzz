import java.lang.instrument.*;

public class MyJVMTest_10884 {

    static String agentArgs = "Kkw?NY0jAf";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10884().premain(agentArgs);
    }
}
