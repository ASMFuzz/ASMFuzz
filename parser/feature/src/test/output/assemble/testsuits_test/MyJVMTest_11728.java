import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class MyJVMTest_11728 {

    static ThreadMXBean tm = ManagementFactory.getThreadMXBean();

    void testThreadCpuMonitoring() throws Exception {
        if (!tm.isThreadCpuTimeSupported()) {
            System.out.println("JVM does not support thread CPU time monitoring");
            return;
        }
        if (tm.isThreadCpuTimeEnabled()) {
            tm.setThreadCpuTimeEnabled(false);
        }
        if (tm.isThreadCpuTimeEnabled()) {
            throw new RuntimeException("TEST FAILED: " + "Expected thread CPU time monitoring to be disabled");
        }
        tm.setThreadCpuTimeEnabled(false);
        tm.setThreadCpuTimeEnabled(false);
        if (tm.isThreadCpuTimeEnabled()) {
            throw new RuntimeException("TEST FAILED: " + "Expected thread CPU time monitoring to be disabled");
        }
        tm.setThreadCpuTimeEnabled(true);
        if (!tm.isThreadCpuTimeEnabled()) {
            throw new RuntimeException("TEST FAILED: " + "Expected thread CPU time monitoring to be disabled");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11728().testThreadCpuMonitoring();
    }
}
