import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_7805 {

    static int value = 0;

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "l8&w=!W)Gw";

    int setInt(String name, int value) {
        new DynamicVMOption(name).setValue(Integer.toString(value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7805().setInt(name, value);
    }
}
