import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_2939 {

    static String value = "!VbO97XAXT";

    void setValue(String newValue) {
        mxBean.setVMOption(name, newValue);
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "PQvRlQcIPO";

    String setString(String name, String value) {
        new DynamicVMOption(name).setValue(value);
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2939().setString(name, value);
    }
}
