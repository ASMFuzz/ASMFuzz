public class MyJVMTest_6451 {

    void test2() {
        try (@SuppressWarnings("deprecation") AutoCloseable r4 = new DeprecatedAutoCloseable()) {
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6451().test2();
    }
}
