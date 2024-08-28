public class MyJVMTest_4217 {

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
        new MyJVMTest_4217().instTest();
    }
}
