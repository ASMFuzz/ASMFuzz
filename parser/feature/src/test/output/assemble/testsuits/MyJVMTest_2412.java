import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

public class MyJVMTest_2412 {

    static HotSpotDiagnosticMXBean mbean = null;

    static String COMPILE_THRESHOLD_SCALING = "CompileThresholdScaling";

    static String EXPECTED_VALUE = "0.14";

    VMOption checkVMOption(HotSpotDiagnosticMXBean mbean) {
        VMOption option = mbean.getVMOption(COMPILE_THRESHOLD_SCALING);
        if (!option.getValue().equalsIgnoreCase(EXPECTED_VALUE)) {
            throw new RuntimeException("Unexpected value: " + option.getValue() + " expected: " + EXPECTED_VALUE);
        }
        return option;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2412().checkVMOption(mbean);
    }
}
