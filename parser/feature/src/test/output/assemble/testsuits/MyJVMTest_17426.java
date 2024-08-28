import java.lang.management.*;
import java.util.*;

public class MyJVMTest_17426 {

    static String name = "p>]_pJ]2]K";

    static MemoryType type = null;

    static List pools = ManagementFactory.getMemoryPoolMXBeans();

    MemoryType checkPoolType(String name, MemoryType type) throws Exception {
        for (ListIterator iter = pools.listIterator(); iter.hasNext(); ) {
            MemoryPoolMXBean pool = (MemoryPoolMXBean) iter.next();
            if (pool.getName().equals(name)) {
                if (pool.getType() != type) {
                    throw new RuntimeException("TEST FAILED: " + "Pool " + pool.getName() + " is of type " + pool.getType() + " but expected to be " + type);
                } else {
                    return;
                }
            }
        }
        throw new RuntimeException("TEST FAILED: " + "Pool " + name + " is of type " + type + " not found");
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17426().checkPoolType(name, type);
    }
}
