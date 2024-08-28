import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_17323 {

    static MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    static MemoryMXBean memory = null;

    void checkOS() throws Exception {
        com.sun.management.OperatingSystemMXBean os = newPlatformMXBeanProxy(server, OPERATING_SYSTEM_MXBEAN_NAME, com.sun.management.OperatingSystemMXBean.class);
        System.out.println("# CPUs = " + os.getAvailableProcessors());
        System.out.println("Committed virtual memory = " + os.getCommittedVirtualMemorySize());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17323().checkOS();
    }
}
