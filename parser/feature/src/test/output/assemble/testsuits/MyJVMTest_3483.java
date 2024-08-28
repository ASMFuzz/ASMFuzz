public class MyJVMTest_3483 {

    static Runnable sr = null;

    void m1() {
        sr = () -> {
            sr.run();
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3483().m1();
    }
}
