import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

public class MyJVMTest_1156 {

    static HotSpotDiagnosticMXBean mbean = null;

    static String HEAP_DUMP_ON_OOM = "HeapDumpOnOutOfMemoryError";

    static String EXPECTED_VALUE = "true";

    static String BAD_OPTION = "BadOption";

    VMOption checkVMOption(HotSpotDiagnosticMXBean mbean) {
        VMOption option = mbean.getVMOption(HEAP_DUMP_ON_OOM);
        if (!option.getValue().equalsIgnoreCase(EXPECTED_VALUE)) {
            throw new RuntimeException("Unexpected value: " + option.getValue() + " expected: " + EXPECTED_VALUE);
        }
        boolean iae = false;
        try {
            mbean.getVMOption(BAD_OPTION);
        } catch (IllegalArgumentException e) {
            iae = true;
        }
        if (!iae) {
            throw new RuntimeException("Invalid VM Option" + " was not detected");
        }
        return option;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1156().checkVMOption(mbean);
    }
}
