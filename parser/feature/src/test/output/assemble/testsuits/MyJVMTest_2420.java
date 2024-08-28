import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class MyJVMTest_2420 {

    boolean isEpsilonEnabled() {
        for (GarbageCollectorMXBean bean : ManagementFactory.getGarbageCollectorMXBeans()) {
            if (bean.getName().contains("Epsilon")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2420().isEpsilonEnabled());
    }
}
