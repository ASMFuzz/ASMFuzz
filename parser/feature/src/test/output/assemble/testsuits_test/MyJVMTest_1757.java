import java.lang.management.*;

public class MyJVMTest_1757 {

    static boolean expectedValue = true;

    static ThreadMXBean tm = ManagementFactory.getThreadMXBean();

    boolean checkThreadContentionMonitoring(boolean expectedValue) throws Exception {
        boolean value = tm.isThreadContentionMonitoringEnabled();
        if (value != expectedValue) {
            throw new RuntimeException("TEST FAILED: " + "isThreadContentionMonitoringEnabled() returns " + value + " but expected to be " + expectedValue);
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1757().checkThreadContentionMonitoring(expectedValue);
    }
}
