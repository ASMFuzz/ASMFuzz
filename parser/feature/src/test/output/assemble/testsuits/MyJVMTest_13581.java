public class MyJVMTest_13581 {

    static Runnable static_r = () -> {
        final int x;
        x = 1;
    };

    void instTest() {
        Runnable static_r = () -> {
            final int x;
            x = 1;
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13581().instTest();
    }
}
