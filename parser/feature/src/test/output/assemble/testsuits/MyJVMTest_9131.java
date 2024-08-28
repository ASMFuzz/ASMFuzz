public class MyJVMTest_9131 {

    static String agentArgs = "5U+$=$(D, ";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent0100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9131().premain(agentArgs);
    }
}
