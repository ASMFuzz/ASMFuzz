import java.lang.management.*;
import java.util.*;

public class MyJVMTest_13238 {

    static MemoryPoolMXBean p = null;

    MemoryPoolMXBean checkUsageThreshold(MemoryPoolMXBean p) throws Exception {
        if (!p.isUsageThresholdSupported()) {
            return;
        }
        long threshold = p.getUsageThreshold();
        if (threshold != 0) {
            throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " has non-zero threshold (" + threshold);
        }
        if (p.isUsageThresholdExceeded()) {
            throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isUsageThresholdExceeded() returned true" + " but threshold = 0");
        }
        p.setUsageThreshold(1);
        System.gc();
        MemoryUsage u = p.getUsage();
        if (u.getUsed() >= 1) {
            if (!p.isUsageThresholdExceeded()) {
                throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isUsageThresholdExceeded() returned false but " + " threshold(" + p.getUsageThreshold() + ") <= used(" + u.getUsed() + ")");
            }
        } else {
            if (p.isUsageThresholdExceeded()) {
                throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isUsageThresholdExceeded() returned true but" + " threshold(" + p.getUsageThreshold() + ") > used(" + u.getUsed() + ")");
            }
        }
        p.setUsageThreshold(0);
        if (p.isUsageThresholdExceeded()) {
            throw new RuntimeException("TEST FAILED: " + "Pool " + p.getName() + " isUsageThresholdExceeded() returned true but threshold = 0");
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13238().checkUsageThreshold(p);
    }
}
