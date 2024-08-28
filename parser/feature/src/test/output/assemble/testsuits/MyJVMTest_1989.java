import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_1989 {

    String getValue() {
        return mxBean.getVMOption(name).getValue();
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "/, G=+Yi^#";

    String getString(String name) {
        return new DynamicVMOption(name).getValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1989().getString(name));
    }
}
