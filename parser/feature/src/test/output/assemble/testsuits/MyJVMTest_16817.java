import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_16817 {

    static MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    static ObjectName memory = null;

    static ObjectName heapPool = null;

    static ObjectName nonHeapPool = null;

    void checkEnum() throws Exception {
        String type = (String) server.getAttribute(heapPool, "Type");
        if (!type.equals("HEAP")) {
            throw new RuntimeException("TEST FAILED: " + " incorrect memory type for " + heapPool);
        }
        type = (String) server.getAttribute(nonHeapPool, "Type");
        if (!type.equals("NON_HEAP")) {
            throw new RuntimeException("TEST FAILED: " + " incorrect memory type for " + nonHeapPool);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16817().checkEnum();
    }
}
