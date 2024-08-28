public class MyJVMTest_13710 {

    static int nanos = 2;

    int test(int nanos) {
        try {
            WaitTooLong.class.wait(Long.MAX_VALUE, nanos);
        } catch (IllegalMonitorStateException expected) {
        } catch (IllegalArgumentException | InterruptedException unexpected) {
            throw new RuntimeException("Unexpected", unexpected);
        }
        return nanos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13710().test(nanos);
    }
}
