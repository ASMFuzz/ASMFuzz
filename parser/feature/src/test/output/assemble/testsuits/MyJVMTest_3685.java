public class MyJVMTest_3685 {

    static String agentArgs = "[9t|=>y$^R";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3685().premain(agentArgs);
    }
}
