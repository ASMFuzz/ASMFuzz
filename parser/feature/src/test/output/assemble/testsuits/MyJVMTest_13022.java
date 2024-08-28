public class MyJVMTest_13022 {

    static String agentArgs = "6WXRkow-z1";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13022().premain(agentArgs);
    }
}
