import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_10839 {

    static MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    static ObjectName memory = null;

    static ObjectName os = null;

    void checkOS() throws Exception {
        Integer cpus = (Integer) server.getAttribute(os, "AvailableProcessors");
        System.out.println("# CPUs = " + cpus);
        Long vmem = (Long) server.getAttribute(os, "CommittedVirtualMemorySize");
        System.out.println("Committed virtual memory = " + vmem);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10839().checkOS();
    }
}
