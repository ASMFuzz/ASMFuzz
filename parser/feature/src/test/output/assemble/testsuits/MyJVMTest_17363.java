import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_17363 {

    static int value = 0;

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "/cg_g.X+FN";

    int setInt(String name, int value) {
        new DynamicVMOption(name).setValue(Integer.toString(value));
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17363().setInt(name, value);
    }
}
