import java.lang.management.*;
import java.util.*;

public class MyJVMTest_12435 {

    static int HEAP = 0;

    static int NONHEAP = 1;

    static int NUM_TYPES = 2;

    static int[] expectedMinNumPools = new int[2];

    static int[] expectedMaxNumPools = new int[2];

    static String[] types = { "heap", "non-heap" };

    static List pools = ManagementFactory.getMemoryPoolMXBeans();

    void checkMemoryPools() throws Exception {
        List pools = ManagementFactory.getMemoryPoolMXBeans();
        boolean hasPerm = false;
        int[] numPools = new int[NUM_TYPES];
        for (ListIterator iter = pools.listIterator(); iter.hasNext(); ) {
            MemoryPoolMXBean pool = (MemoryPoolMXBean) iter.next();
            if (pool.getType() == MemoryType.HEAP) {
                numPools[HEAP]++;
            }
            if (pool.getType() == MemoryType.NON_HEAP) {
                numPools[NONHEAP]++;
            }
            if (pool.getName().toLowerCase().contains("perm")) {
                hasPerm = true;
            }
        }
        if (hasPerm) {
            expectedMinNumPools[NONHEAP] = 2;
            expectedMaxNumPools[NONHEAP] = 4;
        }
        for (int i = 0; i < NUM_TYPES; i++) {
            if (numPools[i] < expectedMinNumPools[i] || numPools[i] > expectedMaxNumPools[i]) {
                throw new RuntimeException("TEST FAILED: " + "Number of " + types[i] + " pools = " + numPools[i] + " but expected <= " + expectedMaxNumPools[i] + " and >= " + expectedMinNumPools[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12435().checkMemoryPools();
    }
}
