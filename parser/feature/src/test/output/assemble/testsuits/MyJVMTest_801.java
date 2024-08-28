import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class MyJVMTest_801 {

    static ThreadMXBean tm = ManagementFactory.getThreadMXBean();

    void testThreadContentionMonitoring() throws Exception {
        if (!tm.isThreadContentionMonitoringSupported()) {
            System.out.println("JVM does not supports thread contention monitoring");
            return;
        }
        tm.setThreadContentionMonitoringEnabled(false);
        tm.setThreadContentionMonitoringEnabled(false);
        if (tm.isThreadContentionMonitoringEnabled()) {
            throw new RuntimeException("TEST FAILED: " + "Expected thread contention monitoring to be disabled");
        }
        tm.setThreadContentionMonitoringEnabled(true);
        if (!tm.isThreadContentionMonitoringEnabled()) {
            throw new RuntimeException("TEST FAILED: " + "Expected thread contention monitoring to be enabled");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_801().testThreadContentionMonitoring();
    }
}
