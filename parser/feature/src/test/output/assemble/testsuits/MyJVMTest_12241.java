import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_12241 {

    static String value = "pE6=o6+Ccy";

    void setValue(String newValue) {
        mxBean.setVMOption(name, newValue);
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "0R1A\\_g^_w";

    String setString(String name, String value) {
        new DynamicVMOption(name).setValue(value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12241().setString(name, value);
    }
}
