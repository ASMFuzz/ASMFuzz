import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class MyJVMTest_9786 {

    static String poolName = "WZkg8u'ywY";

    MemoryPoolMXBean findPool(String poolName) {
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getName().contains(poolName)) {
                return pool;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9786().findPool(poolName));
    }
}
