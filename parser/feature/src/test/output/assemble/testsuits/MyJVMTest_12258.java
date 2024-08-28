import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_12258 {

    static String name = "m$2CflDR1L";

    static String value = "!+y85;J_EP";

    String checkInvalidValue(String name, String value) {
        try {
            ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).setVMOption(name, value);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new RuntimeException("Expected IllegalArgumentException was not thrown, " + name + "= " + value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12258().checkInvalidValue(name, value);
    }
}
