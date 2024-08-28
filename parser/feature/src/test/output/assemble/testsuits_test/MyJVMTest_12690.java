import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_12690 {

    static String name = "`Km~}@sPW'";

    boolean checkIsWritable(String name) {
        VMOption option = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).getVMOption(name);
        if (!option.isWriteable()) {
            throw new RuntimeException(name + " is not writable");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12690().checkIsWritable(name));
    }
}
