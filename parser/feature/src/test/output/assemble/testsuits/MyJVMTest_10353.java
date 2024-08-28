public class MyJVMTest_10353 {

    static Runnable ir = null;

    static Runnable sr = null;

    void m2() {
        ir = () -> {
            ir.run();
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10353().m2();
    }
}
