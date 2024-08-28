import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;
import java.lang.management.ManagementFactory;

public class MyJVMTest_11873 {

    static String name = "BgdjRB!:%)";

    int getIntValue(String name) {
        VMOption option = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class).getVMOption(name);
        return Integer.parseInt(option.getValue());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11873().getIntValue(name));
    }
}
