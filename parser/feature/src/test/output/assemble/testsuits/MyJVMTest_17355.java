import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_17355 {

    String getString(String name) {
        return new DynamicVMOption(name).getValue();
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "`=7\"%l>1ZI";

    int getInt(String name) {
        return Integer.parseInt(getString(name));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17355().getInt(name));
    }
}
