import java.lang.management.*;
import java.util.*;

public class MyJVMTest_10797 {

    static MemoryPoolMXBean p = null;

    MemoryPoolMXBean checkCollectionUsageThreshold(MemoryPoolMXBean p) throws Exception {
        if (!p.isCollectionUsageThresholdSupported()) {
            return;
        }
        long threshold = p.getCollectionUsageThreshold();
        if (threshold != 0) {
            throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " has non-zero threshold (" + threshold);
        }
        if (p.isCollectionUsageThresholdExceeded()) {
            throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isCollectionUsageThresholdExceeded() returned true" + " but threshold = 0");
        }
        p.setCollectionUsageThreshold(1);
        MemoryUsage u = p.getCollectionUsage();
        if (u == null) {
            if (p.isCollectionUsageThresholdExceeded()) {
                throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isCollectionUsageThresholdExceeded() returned true but" + " getCollectionUsage() return null");
            }
        } else if (u.getUsed() >= 1) {
            if (!p.isCollectionUsageThresholdExceeded()) {
                throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isCollectionUsageThresholdExceeded() returned false but " + " threshold(" + p.getCollectionUsageThreshold() + ") < used(" + u.getUsed() + ")");
            }
        } else {
            if (p.isCollectionUsageThresholdExceeded()) {
                throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isCollectionUsageThresholdExceeded() returned true but" + " threshold(" + p.getCollectionUsageThreshold() + ") > used(" + u.getUsed() + ")");
            }
        }
        p.setCollectionUsageThreshold(0);
        if (p.isCollectionUsageThresholdExceeded()) {
            throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isCollectionUsageThresholdExceeded() returned true but threshold = 0");
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10797().checkCollectionUsageThreshold(p);
    }
}
