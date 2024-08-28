public class MyJVMTest_10145 {

    void test() {
        Runnable[] rs = { () -> {
            String x = null;
        }, () -> {
            String x = null;
        } };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10145().test();
    }
}
