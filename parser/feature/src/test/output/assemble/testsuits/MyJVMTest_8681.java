import java.lang.instrument.*;

public class MyJVMTest_8681 {

    static String agentArgs = " 'd\"vuu,GW";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1111Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8681().premain(agentArgs);
    }
}
