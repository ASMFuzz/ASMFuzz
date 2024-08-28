import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_7798 {

    String getString(String name) {
        return new DynamicVMOption(name).getValue();
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "5xq/HYU*!(";

    int getInt(String name) {
        return Integer.parseInt(getString(name));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7798().getInt(name));
    }
}
