import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_8045 {

    static String name = ")%!\\[!4r$C";

    static String value = "2Wwe)vU1S}";

    String checkValidValue(String name, String value) {
        ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).setVMOption(name, value);
        VMOption option = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).getVMOption(name);
        if (!option.getValue().equals(value)) {
            throw new RuntimeException("Actual value of " + name + " \"" + option.getValue() + "\" not equal origin \"" + value + "\"");
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8045().checkValidValue(name, value);
    }
}
