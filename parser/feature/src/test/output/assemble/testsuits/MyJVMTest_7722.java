import java.lang.management.*;
import java.util.*;

public class MyJVMTest_7722 {

    static long initSize = 8860163577637948091L;

    static long maxSize = 9223372036854775807L;

    long testMemoryBean(long initSize, long maxSize) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long heapInit = memoryMXBean.getHeapMemoryUsage().getInit();
        long heapCommitted = memoryMXBean.getHeapMemoryUsage().getCommitted();
        long heapMax = memoryMXBean.getHeapMemoryUsage().getMax();
        long nonHeapInit = memoryMXBean.getNonHeapMemoryUsage().getInit();
        long nonHeapCommitted = memoryMXBean.getNonHeapMemoryUsage().getCommitted();
        long nonHeapMax = memoryMXBean.getNonHeapMemoryUsage().getMax();
        if (initSize > 0 && heapInit != initSize) {
            throw new IllegalStateException("Init heap size is wrong: " + heapInit + " vs " + initSize);
        }
        if (maxSize > 0 && heapMax != maxSize) {
            throw new IllegalStateException("Max heap size is wrong: " + heapMax + " vs " + maxSize);
        }
        if (initSize > 0 && maxSize > 0 && initSize != maxSize && heapCommitted == heapMax) {
            throw new IllegalStateException("Committed heap size is max: " + heapCommitted + " (init: " + initSize + ", max: " + maxSize + ")");
        }
        if (initSize > 0 && maxSize > 0 && initSize == maxSize && heapCommitted != heapMax) {
            throw new IllegalStateException("Committed heap size is not max: " + heapCommitted + " (init: " + initSize + ", max: " + maxSize + ")");
        }
        if (initSize > 0 && heapCommitted < initSize) {
            throw new IllegalStateException("Committed heap size is below min: " + heapCommitted + " (init: " + initSize + ", max: " + maxSize + ")");
        }
        return initSize;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7722().testMemoryBean(initSize, maxSize);
    }
}
