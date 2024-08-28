import java.lang.management.*;
import java.util.*;

public class MyJVMTest_13956 {

    static MemoryPoolMXBean pool = null;

    static String INDENT = "    ";

    MemoryPoolMXBean printMemoryPool(MemoryPoolMXBean pool) {
        System.out.println(INDENT + "Memory Pool name: " + pool.getName());
        System.out.println(INDENT + "Type: " + pool.getType());
        System.out.println(INDENT + "Memory Usage: " + pool.getUsage());
        System.out.println(INDENT + "Threshold: " + (pool.isUsageThresholdSupported() ? pool.getUsageThreshold() : -1));
        System.out.println(INDENT + "ThresholdCount: " + (pool.isUsageThresholdSupported() ? pool.getUsageThresholdCount() : -1));
        System.out.print(INDENT + "Manager = [");
        String[] mgrs = pool.getMemoryManagerNames();
        for (int i = 0; i < mgrs.length; i++) {
            System.out.print(mgrs[i]);
            if (i < (mgrs.length - 1)) {
                System.out.print(" | ");
            }
        }
        System.out.println("]");
        return pool;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13956().printMemoryPool(pool);
    }
}
