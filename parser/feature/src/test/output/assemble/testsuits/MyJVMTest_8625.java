public class MyJVMTest_8625 {

    static String agentArgs = "X\\:\"MfBD'3";

    String premain(String agentArgs) {
        System.out.println("Hello from Single-Arg InheritAgent1100Super!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
        return agentArgs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8625().premain(agentArgs);
    }
}
