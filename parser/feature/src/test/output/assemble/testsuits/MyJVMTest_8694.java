import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class MyJVMTest_8694 {

    boolean isEnabled() {
        for (GarbageCollectorMXBean bean : ManagementFactory.getGarbageCollectorMXBeans()) {
            if (bean.getName().contains("Shenandoah")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8694().isEnabled());
    }
}
