import java.lang.management.*;
import java.util.*;

public class MyJVMTest_7733 {

    static MemoryManagerMXBean mgr = null;

    static String INDENT = "    ";

    MemoryManagerMXBean printMemoryManager(MemoryManagerMXBean mgr) {
        if (mgr instanceof GarbageCollectorMXBean) {
            GarbageCollectorMXBean gc = (GarbageCollectorMXBean) mgr;
            System.out.println(INDENT + "Garbage Collector name: " + gc.getName());
            System.out.println(INDENT + "GC Count: " + gc.getCollectionCount());
            System.out.println(INDENT + "GC Time : " + gc.getCollectionTime());
        } else {
            System.out.println(INDENT + "Memory Manager name: " + mgr.getName());
        }
        System.out.print("Pool = [");
        String[] pools = mgr.getMemoryPoolNames();
        for (int i = 0; i < pools.length; i++) {
            System.out.print(INDENT + pools[i]);
            if (i < (pools.length - 1)) {
                System.out.print(" | ");
            }
        }
        System.out.println("]");
        return mgr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7733().printMemoryManager(mgr);
    }
}
