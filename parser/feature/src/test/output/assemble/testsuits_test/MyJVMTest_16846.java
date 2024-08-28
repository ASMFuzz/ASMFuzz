public class MyJVMTest_16846 {

    void testNoSuppression() {
        try (AutoCloseable resource = null) {
            throw new java.io.IOException();
        } catch (java.io.IOException ioe) {
            Throwable[] suppressed = ioe.getSuppressed();
            if (suppressed.length != 0) {
                throw new AssertionError("Non-empty suppressed exceptions", ioe);
            }
        } catch (Exception e) {
            throw new AssertionError("Should not be reached", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16846().testNoSuppression();
    }
}
