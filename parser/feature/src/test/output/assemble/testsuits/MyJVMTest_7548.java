public class MyJVMTest_7548 {

    void testNormalCompletion() {
        try (AutoCloseable resource = null) {
            return;
        } catch (Exception e) {
            throw new AssertionError("Should not be reached", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7548().testNormalCompletion();
    }
}
