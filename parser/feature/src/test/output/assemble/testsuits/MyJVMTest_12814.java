public class MyJVMTest_12814 {

    static Runnable sr = null;

    void m1() {
        sr = () -> {
            sr.run();
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12814().m1();
    }
}
