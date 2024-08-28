import java.lang.management.*;
import javax.management.*;
import static java.lang.management.ManagementFactory.*;

public class MyJVMTest_9250 {

    static MemoryMXBean memory = null;

    static MemoryPoolMXBean heapPool = null;

    static MemoryPoolMXBean nonHeapPool = null;

    void checkEnum() throws Exception {
        MemoryType type = heapPool.getType();
        if (type != MemoryType.HEAP) {
            throw new RuntimeException("TEST FAILED: " + " incorrect memory type for " + heapPool.getName());
        }
        type = nonHeapPool.getType();
        if (type != MemoryType.NON_HEAP) {
            throw new RuntimeException("TEST FAILED: " + " incorrect memory type for " + nonHeapPool.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9250().checkEnum();
    }
}
