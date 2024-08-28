import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_2955 {

    static String name = "k.$*Roq|J{";

    static String value = "9M#eD%E>&&";

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
        new MyJVMTest_2955().checkInvalidValue(name, value);
    }
}
