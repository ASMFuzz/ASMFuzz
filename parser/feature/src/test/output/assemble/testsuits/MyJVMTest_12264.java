public class MyJVMTest_12264 {

    static A strategy = null;

    A m(A strategy) {
        throw new AssertionError("Should not get here.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12264().m(strategy));
    }
}
