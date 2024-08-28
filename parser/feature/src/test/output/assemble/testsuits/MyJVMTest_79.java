import java.lang.management.*;

public class MyJVMTest_79 {

    static boolean expectedValue = true;

    static ThreadMXBean tm = ManagementFactory.getThreadMXBean();

    boolean checkThreadCpuTime(boolean expectedValue) throws Exception {
        boolean value = tm.isThreadCpuTimeEnabled();
        if (value != expectedValue) {
            throw new RuntimeException("TEST FAILED: " + "isThreadCpuTimeEnabled() returns " + value + " but expected to be " + expectedValue);
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_79().checkThreadCpuTime(expectedValue);
    }
}
