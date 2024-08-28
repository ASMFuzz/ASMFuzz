public class MyJVMTest_8552 {

    static Runnable static_r = () -> {
        final int x;
        x = 1;
    };

    void staticTest() {
        Runnable static_r = () -> {
            final int x;
            x = 1;
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8552().staticTest();
    }
}
