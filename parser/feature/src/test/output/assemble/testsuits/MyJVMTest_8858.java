public class MyJVMTest_8858 {

    void premain() {
        System.out.println("Hello from ZeroArgInheritAgent!");
        throw new Error("ERROR: THIS AGENT SHOULD NOT HAVE BEEN CALLED.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8858().premain();
    }
}
