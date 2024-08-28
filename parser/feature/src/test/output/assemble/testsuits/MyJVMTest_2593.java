import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_2593 {

    static String name = "\\+iz~U=o !";

    int getIntValue(String name) {
        VMOption option = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).getVMOption(name);
        return Integer.parseInt(option.getValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2593().getIntValue(name));
    }
}
