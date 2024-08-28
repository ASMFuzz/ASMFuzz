import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_8576 {

    static MemoryMXBean memory = null;

    static MemoryPoolMXBean heapPool = null;

    static MemoryPoolMXBean nonHeapPool = null;

    void checkMemoryUsage() throws Exception {
        MemoryUsage u1 = memory.getHeapMemoryUsage();
        MemoryUsage u2 = memory.getNonHeapMemoryUsage();
        MemoryUsage u3 = heapPool.getUsage();
        MemoryUsage u4 = nonHeapPool.getUsage();
        if (u1.getCommitted() < 0 || u2.getCommitted() < 0 || u3.getCommitted() < 0 || u4.getCommitted() < 0) {
            throw new RuntimeException("TEST FAILED: " + " expected non-negative committed usage");
        }
        memory.gc();
        MemoryUsage u5 = heapPool.getCollectionUsage();
        if (u5.getCommitted() < 0) {
            throw new RuntimeException("TEST FAILED: " + " expected non-negative committed collected usage");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8576().checkMemoryUsage();
    }
}
