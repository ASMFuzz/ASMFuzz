public class MyJVMTest_15939 {

    void test2() {
        try (@SuppressWarnings("deprecation") AutoCloseable r4 = new DeprecatedAutoCloseable()) {
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15939().test2();
    }
}
