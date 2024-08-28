import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class MyJVMTest_619 {

    static String poolName = "*!.uHpxS7C";

    MemoryPoolMXBean findPool(String poolName) {
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getName().contains(poolName)) {
                return pool;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_619().findPool(poolName));
    }
}
