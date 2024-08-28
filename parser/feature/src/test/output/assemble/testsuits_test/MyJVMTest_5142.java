public class MyJVMTest_5142 {

    static SAM s = null;

    SAM test(SAM s) throws Throwable {
        s.hashCode();
        s.equals(null);
        s.toString();
        try {
            s.notify();
        } catch (final IllegalMonitorStateException e) {
        }
        try {
            s.notifyAll();
        } catch (final IllegalMonitorStateException e) {
        }
        try {
            s.wait(1);
        } catch (final IllegalMonitorStateException | InterruptedException e) {
        }
        try {
            s.wait(1, 1);
        } catch (final IllegalMonitorStateException | InterruptedException e) {
        }
        try {
            s.wait();
        } catch (final IllegalMonitorStateException | InterruptedException e) {
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5142().test(s);
    }
}
