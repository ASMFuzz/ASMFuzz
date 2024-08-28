import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_17614 {

    static String name = "d@;4'4Fos~";

    static String value = "\\[si;GBhLI";

    String checkValidValue(String name, String value) {
        ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).setVMOption(name, value);
        VMOption option = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).getVMOption(name);
        if (!option.getValue().equals(value)) {
            throw new RuntimeException("Actual value of " + name + " \"" + option.getValue() + "\" not equal origin \"" + value + "\"");
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17614().checkValidValue(name, value);
    }
}
