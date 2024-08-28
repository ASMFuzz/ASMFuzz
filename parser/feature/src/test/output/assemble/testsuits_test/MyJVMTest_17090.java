public class MyJVMTest_17090 {

    void testNormalCompletion() {
        try (AutoCloseable resource = null) {
            return;
        } catch (Exception e) {
            throw new AssertionError("Should not be reached", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17090().testNormalCompletion();
    }
}
